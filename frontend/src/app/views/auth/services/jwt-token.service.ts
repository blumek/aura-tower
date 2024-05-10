import { Injectable } from '@angular/core';
import { TokenResponse } from '../models/auth';
import { jwtDecode } from 'jwt-decode';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { Observable, catchError, tap } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class JwtTokenService {

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  setToken(token: TokenResponse) {
    if (token) {
      localStorage.setItem('token', JSON.stringify(token));
    }
  }

  getToken(): any{
    const token = localStorage.getItem('token');

    return token ? JSON.parse(token) : null;
  }

  getAccessToken(): string | null {
    const token = localStorage.getItem('token');

    return token ? JSON.parse(token).accessToken : null
  }

  getRefreshToken(): string | null {
    const token = localStorage.getItem('token');

    return token ? JSON.parse(token).refreshToken : null
  }

  removeToken(): void {
    localStorage.removeItem('token');
  }

  isAccessTokenExpired(): boolean {
    const accessToken = this.getAccessToken();
    const decodedToken = this.decodeToken(accessToken)
    let decodedTokenExp = null

    if (decodedToken) {
      decodedTokenExp = decodedToken.exp
    }

    return decodedTokenExp ? 1000 * Number(decodedTokenExp) - new Date().getTime() < 5000 : false;
  }

  isRefreshTokenExpired(): boolean {
    const refreshToken = this.getRefreshToken();
    const decodedTokenExp = this.decodeToken(refreshToken).exp

    return decodedTokenExp ? 1000 * Number(decodedTokenExp) - new Date().getTime() < 5000 : false;
  }

  decodeToken(token: string | null): any {
    return token ? jwtDecode(token) : null
  }

  refreshToken(): Observable<TokenResponse> {
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
        throw err;
      })
    )
  }
}
