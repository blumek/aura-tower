import { Component } from '@angular/core';
import { FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.scss'
})
export class SignInComponent {
  hidePassword: boolean = true;
  signInForm: FormGroup<any> = this.fb.group({
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

}
