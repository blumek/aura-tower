import { Injectable } from '@angular/core';
import { SignUpFormRaw, signInFormRaw } from '../models/forms';
import { Observable, concatMap, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { ReminderQuestions, SignInData, SignUpData, SignUpResponse, TokenResponse } from '../models/auth';
import { JwtTokenService } from './jwt-token.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor (
    private http: HttpClient,
    private jwtTokenService: JwtTokenService,
    private router: Router
  ) { }

  signUp(signUpForm: SignUpFormRaw): Observable<Object> {
    const singUpData: SignUpData = {
      username: signUpForm.userName!,
      password: signUpForm.password!,
      reminderQuestionId: signUpForm.auxiliaryQuestion!,
      reminderQuestionAnswer: signUpForm.auxiliaryAnswer!
    }

    return this.http.post<SignUpResponse>(environment.authentication.signUp, singUpData).pipe(
      concatMap(() => {
        return this.signIn({userName: singUpData.username, password: singUpData.password})
      })
    );
  }

  signIn(signInForm: signInFormRaw): Observable<TokenResponse> {
    const signInData: SignInData = {
      username: signInForm.userName!,
      password: signInForm.password!,
    }

    return this.http.post<TokenResponse>(environment.authentication.signIn, signInData).pipe(
      tap((tokenResponse: any) => {
        this.jwtTokenService.setToken(tokenResponse)
      })
    );
  }

  logout(): void {
    this.jwtTokenService.removeToken();
    this.router.navigate(['/auth/sign-in']);
  }

  getRemindQuestions(): Observable<ReminderQuestions[]> {
    return this.http.get<ReminderQuestions[]>(environment.catalogs.reminderQuestions)
  }
}
