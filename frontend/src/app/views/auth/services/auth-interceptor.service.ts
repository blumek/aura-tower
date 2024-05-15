import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, concatMap, of } from 'rxjs';
import { JwtTokenService } from './jwt-token.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';
import { Router } from '@angular/router';
import { TokenResponse } from '../models/auth';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthInterceptorService implements HttpInterceptor {
  constructor(
    private jwtTokenService: JwtTokenService,
    private snackBarService: SnackbarService,
    private router: Router
  ) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (req.url === environment.authentication.refreshToken) {
      return next.handle(req);
    }

    if (this.jwtTokenService.isTokenValid() && this.jwtTokenService.isAccessTokenExpired()) {
      if (this.jwtTokenService.isRefreshTokenExpired()) {
        this.jwtTokenService.removeToken();
        this.router.navigate(['/auth/sign-in']);
        this.snackBarService.openSnackBar('Seasion expired', true);

        return of();
      } else {
        return this.jwtTokenService.refreshTokens().pipe(
          concatMap((token) => {
            const newReq = this.addAuthHeader(req, token);

            return next.handle(newReq);
          })
        );
      }
    }
    
    const token = this.jwtTokenService.getToken();
    const newReq = token ? this.addAuthHeader(req, token) : req;

    return next.handle(newReq);
  }

  addAuthHeader(req: HttpRequest<any>, token: TokenResponse) {
    return token
      ? req.clone({
          setHeaders: { Authorization: `Bearer ${token.accessToken}` },
        })
      : req;
  }
}
