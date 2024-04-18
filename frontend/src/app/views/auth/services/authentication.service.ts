import { Injectable } from '@angular/core';
import { signUpForm } from '../models/forms';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor (
    private http: HttpClient
  ) { }

  signUp(signUpForm: signUpForm): Observable<any> {
    return this.http.post(environment.authentication.signUp, signUpForm);
  }
}
