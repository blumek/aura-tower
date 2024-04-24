import { Injectable } from '@angular/core';
import { SignUpForm, SignUpFormRaw } from '../models/forms';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';
import { SignUp } from '../models/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor (
    private http: HttpClient
  ) { }

  signUp(signUpForm: SignUpFormRaw): Observable<any> {
    const singUpData: SignUp = {
      username: signUpForm.userName!,
      password: signUpForm.password!,
      reminderQuestionId: signUpForm.auxiliaryQuestion!,
      reminderQuestionAnswer: signUpForm.auxiliaryAnswer!
    }

    return this.http.post(environment.authentication.signUp, signUpForm);
  }
}
