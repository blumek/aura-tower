import { Component } from '@angular/core';
import { FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { signInForm } from '../../../shared/models/auth';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.scss'
})
export class SignInComponent {
  hidePassword: boolean = true;
  signInForm: FormGroup<signInForm> = this.fb.group({
    userName: ['', Validators.required],
    password: ['', Validators.required]
  })

  constructor(
    private router: Router,
    private fb: NonNullableFormBuilder
  ) { }

  onLinkClick(link: string) {
    this.router.navigate(['auth/', link])
  }

  get userNameControl(): FormControl<string> {
    return this.signInForm.get('userName') as FormControl<string>
  }

  get passwordControl(): FormControl<string> {
    return this.signInForm.get('password') as FormControl<string>
  }
  
}
