import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { JwtTokenService } from '../../views/auth/services/jwt-token.service';

export const authGuard: CanActivateFn = (route, state) => {
  const jwtService = inject(JwtTokenService);
  const router = inject(Router);

  if (jwtService.isAccessTokenExpired() === true) {
    router.navigate(['/auth/sign-in']);
    return false
  }

  return true;
};
