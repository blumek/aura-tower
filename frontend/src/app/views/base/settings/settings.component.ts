import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EditAuthDialogComponent } from '../../../shared/components/dialogs/edit-auth-dialog/edit-auth-dialog.component';
import { AuthenticationService } from '../../auth/services/authentication.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AccountDetailsForm } from '../models/forms';
import { Observable } from 'rxjs';
import { ReminderQuestions } from '../../auth/models/auth';
import { ChangePasswordDialogComponent } from '../../../shared/components/dialogs/change-password-dialog/change-password-dialog.component';

@Component({
  selector: 'at-settings',
  templateUrl: './settings.component.html',
  styleUrl: '../base.component.scss'
})
export class SettingsComponent {
  loading: boolean = false;
  editMode: boolean = false;
  accountDetailsForm: FormGroup<AccountDetailsForm> = this.fb.group({
    userName: ['', Validators.required],
    auxiliaryQuestion: ['', Validators.required],
    auxiliaryAnswer: ['', Validators.required],
  })
  reminderQuestionsList$!: Observable<ReminderQuestions[]>

  constructor(
    private authService: AuthenticationService,
    private fb: FormBuilder,
    private location: Location,
    private matDialog: MatDialog
  ) { }

  get userNameControl(): FormControl<string> {
    return this.accountDetailsForm.get('userName') as FormControl<string>;
  }

  get auxiliaryQuestionControl(): FormControl<string> {
    return this.accountDetailsForm.get('auxiliaryQuestion') as FormControl<string>;
  }

  get auxiliaryAnswerControl(): FormControl<string> {
    return this.accountDetailsForm.get('auxiliaryAnswer') as FormControl<string>;
  }

  goToHeadquarters(): void {
    this.location.back()
  }

  openEditAuthDialog(): void {
    const dialog = this.matDialog.open(EditAuthDialogComponent)
    
    dialog.afterClosed().subscribe((result) => {
      if (result) {
        this.editMode = true;
        this.initDataForEditMode()
      }
    })
  }

  openChangePasswordDialog(): void {
    const dialog = this.matDialog.open(ChangePasswordDialogComponent)
  }

  initDataForEditMode(): void {
    //TODO: implement init data for edit mode

    this.reminderQuestionsList$ = this.authService.getRemindQuestions()

  }

  saveAccountDetails(): void {
    //TODO: implement save account details

    this.editMode = false;
  }


}
