import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ForgotPassForm } from '../models/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-forgot-pass',
  templateUrl: './forgot-pass.component.html',
  styleUrl: '../auth.component.scss'
})
export class ForgotPassComponent {
  loadingButton: boolean = false;
  forgotPassForm: FormGroup<ForgotPassForm> = this.fb.group({
    userName: ['', Validators.required],
    auxiliaryQuestion: ['', Validators.required],
    auxiliaryAnswer: ['', Validators.required],
  })

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthenticationService
  ) { }

  get userNameControl(): FormControl<string> {
    return this.forgotPassForm.get('userName') as FormControl<string>
  }

  get auxiliaryQuestion(): FormControl<string> {
    return this.forgotPassForm.get('auxiliaryQuestion') as FormControl<string>
  }

  get auxiliaryAnswer(): FormControl<string> {
    return this.forgotPassForm.get('auxiliaryAnswer') as FormControl<string>
  }

  goToSignIn(): void {
    this.router.navigate(['/auth/sign-in'])
  }

  remindPassword(): void {

  }
}
