import { Injectable } from '@angular/core';
import { SignUpFormRaw, signInFormRaw } from '../models/forms';
import { Observable, concatMap, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { SignIn, SignUp } from '../models/auth';
import { JwtTokenService } from './jwt-token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor (
    private http: HttpClient,
    private jwtTokenService: JwtTokenService
  ) { }

  signUp(signUpForm: SignUpFormRaw): Observable<Object> {
    const singUpData: SignUp = {
      username: signUpForm.userName!,
      password: signUpForm.password!,
      reminderQuestionId: signUpForm.auxiliaryQuestion!,
      reminderQuestionAnswer: signUpForm.auxiliaryAnswer!
    }

    return this.http.post(environment.authentication.signUp, singUpData).pipe(
      concatMap(() => {
        return this.signIn({userName: singUpData.username, password: singUpData.password})
      })
    );
  }

  signIn(signInForm: signInFormRaw): Observable<any> {
    const signInData: SignIn = {
      username: signInForm.userName!,
      password: signInForm.password!,
    }

    return this.http.post(environment.authentication.signIn, signInData).pipe(
      tap((tokenResponse: any) => {
        this.jwtTokenService.setToken(tokenResponse)
      })
    );
  }
}
