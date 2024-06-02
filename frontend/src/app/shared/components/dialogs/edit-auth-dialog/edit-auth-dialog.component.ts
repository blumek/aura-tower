import { Component } from '@angular/core';
import { MatDialogActions, MatDialogClose, MatDialogContent, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';
import { FormControl, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { InfoComponent } from '../../info/info.component';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'at-edit-auth-dialog',
  standalone: true,
  imports: [InfoComponent, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatIconModule],
  templateUrl: './edit-auth-dialog.component.html',
  styleUrl: './edit-auth-dialog.component.scss'
})
export class EditAuthDialogComponent {
  hidePassword: boolean = true;
  passwordControl = new FormControl('', [Validators.required]);

  constructor(
    private dialogRef: MatDialogRef<EditAuthDialogComponent>
  ) {}

  confirmPassword(): void {
    //TODO: implement confirm password

    this.dialogRef.close(true);
  }
}
