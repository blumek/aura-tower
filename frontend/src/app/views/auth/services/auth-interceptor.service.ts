import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, concatMap, from, of, throwError } from 'rxjs';
import { JwtTokenService } from './jwt-token.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';
import { Router } from '@angular/router';
import { TokenResponse } from '../models/auth';

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
    if (this.jwtTokenService.isAccessTokenExpired()) {
      if (this.jwtTokenService.isRefreshTokenExpired()) {
        this.jwtTokenService.removeToken();
        this.router.navigate(['/auth/sign-in']);
        this.snackBarService.openSnackBar('Sesja wygasła', true);
      } else {
        this.jwtTokenService.refreshTokens().pipe(
          concatMap((token) => {
            const newReq = this.addAuthHeader(req, token);

            return next.handle(newReq);
          })
        );
      }
    } else {
      const token = this.jwtTokenService.getToken();
      const newReq = token ? this.addAuthHeader(req, token) : req;

      return next.handle(newReq);
    }

    return next.handle(req);
  }

  addAuthHeader(req: HttpRequest<any>, token: TokenResponse) {
    return token
      ? req.clone({ setHeaders: { Authorization: `Bearer ${token.accessToken}` } })
      : req;
  }
}
