import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignInForm } from '../models/forms';
import { AuthenticationService } from '../services/authentication.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';

@Component({
  selector: 'at-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrl: '../auth.component.scss'
})
export class SignInComponent {
  hidePassword: boolean = true;
  loadingButton: boolean = false;
  signInForm: FormGroup<SignInForm> = this.fb.group({
    userName: ['', Validators.required],
    password: ['', Validators.required]
  })

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthenticationService,
    private snackbarService: SnackbarService
  ) { }

  get userNameControl(): FormControl<string> {
    return this.signInForm.get('userName') as FormControl<string>
  }

  get passwordControl(): FormControl<string> {
    return this.signInForm.get('password') as FormControl<string>
  }

  onLinkClick(link: string) {
    this.router.navigate(['auth/', link])
  }

  signIn(): void {
    this.loadingButton = true
    const signInFormRaw = this.signInForm.getRawValue();

    this.authService.signIn(signInFormRaw).subscribe({
      next: () => {
        this.snackbarService.openSnackBar('Zalogowano');
        this.router.navigate(['base/headquarters'])
      },
      error: (error) => {
        this.loadingButton = false;

        if (error.status === 400) {
          this.snackbarService.openSnackBar(error.error.message, true);
        } else {
          this.snackbarService.openSnackBar('Error occured', true);
        }
      }
    })
  }
}
