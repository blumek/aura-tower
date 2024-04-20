import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class JwtTokenService {
  constructor() {}

  setToken(token: string) {
    localStorage.setItem('token', token);
  }

  getToken(): string | null {
    const token = localStorage.getItem('token');

    return token ? token : null;
  }

  removeToken(): void {
    localStorage.removeItem('token');
  }
}
