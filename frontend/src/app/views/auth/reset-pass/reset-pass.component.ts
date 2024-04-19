import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { ResetPassForm } from '../models/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-reset-pass',
  templateUrl: './reset-pass.component.html',
  styleUrl: '../auth.component.scss'
})
export class ResetPassComponent {
  hidePassword: boolean = true;
  hideConfirmPassword: boolean = true;
  loadingButton: boolean = false;
  resetPassForm: FormGroup<ResetPassForm> = this.fb.group({
    password: ['', [Validators.required, Validators.minLength(8)]],
    confirmPassword: ['', Validators.required],
  }, {validators: [this.checkPasswords as ValidatorFn]})

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthenticationService
  ) { }

  get passwordControl(): FormControl<string> {
    return this.resetPassForm.get('password') as FormControl<string>
  }

  get confirmPasswordControl(): FormControl<string> {
    return this.resetPassForm.get('confirmPassword') as FormControl<string>
  }

  checkPasswords(formGroup: FormGroup): null | {notSame: boolean} {
    const pass = formGroup.controls['password'].value
    const confirmPassword = formGroup.controls['confirmPassword'].value
    const validation = confirmPassword === pass ? null : {notSame: true}  

    formGroup.controls['confirmPassword'].setErrors(validation)
      
    return validation
  }


  resetPassword() {
    const signUpFormRaw = this.resetPassForm.getRawValue()


  }
}
