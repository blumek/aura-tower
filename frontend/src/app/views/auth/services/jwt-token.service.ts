import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class JwtTokenService {
  constructor() {}

  setToken(token: Token) {
    if (token) {
      localStorage.setItem('token', JSON.stringify(token));
    }
  }

  getToken(): string | null {
    const token = localStorage.getItem('token');

    return token ? token : null;
  }

  removeToken(): void {
    localStorage.removeItem('token');
  }
}
