import { Component } from '@angular/core';
import { FormGroup, Validators, ValidatorFn, FormBuilder, FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { InfoComponent } from '../../info/info.component';
import { ChangePassForm } from '../../../../views/base/models/forms';

@Component({
  selector: 'at-change-password-dialog',
  standalone: true,
  imports: [InfoComponent, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatIconModule],
  templateUrl: './change-password-dialog.component.html',
  styleUrl: './change-password-dialog.component.scss'
})
export class ChangePasswordDialogComponent {
  hideOldPassword: boolean = true;
  hidePassword: boolean = true;
  hideConfirmPassword: boolean = true;
  loadingButton: boolean = false;
  changePassForm: FormGroup<ChangePassForm> = this.fb.group({
    oldPassword: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(8)]],
    confirmPassword: ['', Validators.required],
  }, {validators: [this.checkPasswords as ValidatorFn]})

  constructor(
    private fb: FormBuilder,
    private dialogRef:  MatDialogRef<ChangePasswordDialogComponent>
  ) {}
  
  get oldPasswordControl(): FormControl<string> {
    return this.changePassForm.get('oldPassword') as FormControl<string>
  }

  get passwordControl(): FormControl<string> {
    return this.changePassForm.get('password') as FormControl<string>
  }

  get confirmPasswordControl(): FormControl<string> {
    return this.changePassForm.get('confirmPassword') as FormControl<string>
  }

  checkPasswords(formGroup: FormGroup): null | {notSame: boolean} {
    const pass = formGroup.controls['password'].value
    const confirmPassword = formGroup.controls['confirmPassword'].value
    const validation = confirmPassword === pass ? null : {notSame: true}  

    formGroup.controls['confirmPassword'].setErrors(validation)
      
    return validation
  }

  changePassword() {
    const signUpFormRaw = this.changePassForm.getRawValue()

    //TODO: implement change password

    this.dialogRef.close()
  }
}

