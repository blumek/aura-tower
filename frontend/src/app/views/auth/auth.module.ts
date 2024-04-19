import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './sign-in/sign-in.component';
import { AuthComponent } from './auth.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ForgotPassComponent } from './forgot-pass/forgot-pass.component';
import { ResetPassComponent } from './reset-pass/reset-pass.component';
import { AuthRoutingModule } from './auth-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { ErrorMsgComponent } from '../../shared/components/error-msg/error-msg.component';
import { MatSelectModule } from '@angular/material/select';


const matModules = [
  MatFormFieldModule,
  MatInputModule, 
  MatIconModule,
  MatProgressSpinnerModule,
  MatSelectModule
]

const standaloneComponents = [
  ErrorMsgComponent
]

@NgModule({
  declarations: [
    SignInComponent,
    AuthComponent,
    SignUpComponent,
    ForgotPassComponent,
    ResetPassComponent,
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule,
    matModules,
    standaloneComponents
  ]
})
export class AuthModule { }
