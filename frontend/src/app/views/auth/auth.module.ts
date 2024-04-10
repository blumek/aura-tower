import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './sign-in/sign-in.component';
import { AuthComponent } from './auth.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ForgotPassComponent } from './forgot-pass/forgot-pass.component';



@NgModule({
  declarations: [
    SignInComponent,
    AuthComponent,
    SignUpComponent,
    ForgotPassComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AuthModule { }
