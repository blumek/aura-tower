import { Injectable } from '@angular/core';
import { TokenResponse } from '../models/auth';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class JwtTokenService {
  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  setToken(token: TokenResponse): void {
    localStorage.setItem('token', JSON.stringify(token));
  }

  getToken(): TokenResponse | null {
    const token = localStorage.getItem('token');
    return token ? JSON.parse(token) : null;
  }

  getAccessToken(): string | null {
    const token = this.getToken()

    return token ? token.accessToken : null;
  }

  getRefreshToken(): string | null {
    const token = this.getToken()

    return token ? token.refreshToken : null;
  }

  removeToken(): void {
    localStorage.removeItem('token');
  }

  isAccessTokenExpired(): boolean {
    const accessToken = this.getAccessToken()

    return !!accessToken && this.isTokenExpired(accessToken);
  }

  isRefreshTokenExpired(): boolean {
    const refreshToken = this.getRefreshToken()

    return !!refreshToken && this.isTokenExpired(refreshToken);
  }

  isTokenValid(): any {
    const accessToken = this.getAccessToken()
  
    if (accessToken) {
      return this.decodeToken(accessToken) ? true : false
    }
    return false
  }

  decodeToken(token: string): any {
    const payload = token.split('.')[1];
    
    return JSON.parse(atob(payload));
  }

  getUserName(): string | null {
    const token = this.getAccessToken()
    const decodedToken = token ? this.decodeToken(token) : null;

    return decodedToken ? decodedToken.username : null;
  }

  isTokenExpired(token: string): boolean {
    const decodedToken = this.decodeToken(token),
    currentTime = Date.now() / 1000;

    return decodedToken.exp < currentTime;
  }

  refreshTokens(): Observable<TokenResponse> {
    const body = {
      accessToken: this.getAccessToken(),
      refreshToken: this.getRefreshToken()
    }

    return this.http.post<TokenResponse>(environment.authentication.refreshToken, body).pipe(
      tap((token: TokenResponse) => {
        this.setToken(token);
      }),
      catchError(err => {
        this.removeToken();
        this.router.navigate(['/auth/sign-in']);
        return throwError(() => err);
      })
    )
  }
}
