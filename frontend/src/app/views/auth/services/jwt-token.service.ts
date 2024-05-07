import { Injectable } from '@angular/core';
import { TokenResponse } from '../models/auth';

@Injectable({
  providedIn: 'root',
})
export class JwtTokenService {
  constructor() {}

  setToken(token: TokenResponse) {
    if (token) {
      localStorage.setItem('token', JSON.stringify(token));
    }
  }

  getToken(): string | null {
    const token = localStorage.getItem('token');

    return token ? token : null;
  }

  getAccessToken(): string | null {
    const token = localStorage.getItem('token');

    if (token) {
      return JSON.parse(token).accessToken
    }
    return null
  }

  removeToken(): void {
    localStorage.removeItem('token');
  }
}
