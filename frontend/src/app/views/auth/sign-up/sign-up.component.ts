import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { SignUpForm } from '../models/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';
import { Observable } from 'rxjs';
import { ReminderQuestions } from '../models/auth';

@Component({
  selector: 'at-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrl: '../auth.component.scss'
})
export class SignUpComponent implements OnInit {
  hidePassword: boolean = true;
  hideConfirmPassword: boolean = true;
  loadingButton: boolean = false;
  reminderQuestionsList$!: Observable<ReminderQuestions[]>;
  signUpForm: FormGroup<SignUpForm> = this.fb.group({
    userName: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(8)]],
    confirmPassword: ['', Validators.required],
    auxiliaryQuestion: ['', Validators.required],
    auxiliaryAnswer: ['', Validators.required],
  }, {validators: [this.checkPasswords as ValidatorFn]})

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthenticationService,
    private snackbarService: SnackbarService
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

  get auxiliaryQuestionControl(): FormControl<string> {
    return this.signUpForm.get('auxiliaryQuestion') as FormControl<string>
  }

  get auxiliaryAnswerControl(): FormControl<string> {
    return this.signUpForm.get('auxiliaryAnswer') as FormControl<string>
  }

  ngOnInit(): void {
    this.reminderQuestionsList$ = this.authService.getRemindQuestions()
  }

  checkPasswords(formGroup: FormGroup): null | {notSame: boolean} {
    const pass = formGroup.controls['password'].value
    const confirmPassword = formGroup.controls['confirmPassword'].value
    const validation = confirmPassword === pass ? null : {notSame: true}  

    formGroup.controls['confirmPassword'].setErrors(validation)
      
    return validation
  }

  goToSignIn(): void {
    this.router.navigate(['auth/sign-in'])
  }

  signUp() {
    this.loadingButton = true
    const signUpFormRaw = this.signUpForm.getRawValue()

    this.authService.signUp(signUpFormRaw).subscribe({
      next: () => {
        this.router.navigate(['base/intro'])
      },
      error: () => {
        this.snackbarService.openSnackBar('Wystąpił błąd', true);
        this.loadingButton = false;
      }
    })

  }
}
