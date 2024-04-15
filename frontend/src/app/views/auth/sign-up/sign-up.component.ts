import { Component } from '@angular/core';
import { FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { signUpForm } from '../../../shared/models/auth';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrl: '../auth.component.scss'
})
export class SignUpComponent {
  hidePassword: boolean = true;
  hideConfirmPassword: boolean = true;
  loadingButton: boolean = false;
  signUpForm: FormGroup<signUpForm> = this.fb.group({
    userName: ['', Validators.required],
    password: ['', Validators.required],
    confirmPassword: ['', Validators.required],
    auxiliaryQuestion: ['', Validators.required],
    auxiliaryAnswer: ['', Validators.required],
  })

  constructor(
    private router: Router,
    private fb: NonNullableFormBuilder
  ) { }

  get userNameControl(): FormControl<string> {
    return this.signUpForm.get('userName') as FormControl<string>
  }

  get passwordControl(): FormControl<string> {
    return this.signUpForm.get('password') as FormControl<string>
  }

  get confirmPasswordControl(): FormControl<string> {
    return this.signUpForm.get('confirmPassword') as FormControl<string>
  }

  get auxiliaryQuestion(): FormControl<string> {
    return this.signUpForm.get('auxiliaryQuestion') as FormControl<string>
  }

  get auxiliaryAnswer(): FormControl<string> {
    return this.signUpForm.get('auxiliaryAnswer') as FormControl<string>
  }

  goToSignIn(): void {
    this.router.navigate(['auth/sign-in'])
  }

  signUp() {

  }
}
