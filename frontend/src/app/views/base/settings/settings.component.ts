import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EditAuthDialogComponent } from '../../../shared/components/dialogs/edit-auth-dialog/edit-auth-dialog.component';
import { AuthenticationService } from '../../auth/services/authentication.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AccountDetailsForm } from '../models/forms';
import { Observable } from 'rxjs';
import { ReminderQuestions } from '../../auth/models/auth';
import { ChangePasswordDialogComponent } from '../../../shared/components/dialogs/change-password-dialog/change-password-dialog.component';
import { ThemeService } from '../../../shared/services/theme.service';

@Component({
  selector: 'at-settings',
  templateUrl: './settings.component.html',
  styleUrl: '../base.component.scss'
})
export class SettingsComponent implements OnInit {
  loading: boolean = false;
  editMode: boolean = false;
  appVersion: string = '1.0.0';
  accountDetailsForm: FormGroup<AccountDetailsForm> = this.fb.group({
    userName: ['', Validators.required],
    auxiliaryQuestion: ['', Validators.required],
    auxiliaryAnswer: ['', Validators.required],
  })
  themeForm: FormGroup<{theme: FormControl<boolean | null>}> = this.fb.group({
    theme: [false],
  })
  reminderQuestionsList$!: Observable<ReminderQuestions[]>

  constructor(
    private authService: AuthenticationService,
    private themeService: ThemeService,
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

  get themeControl(): FormControl<boolean> {
    return this.themeForm.get('theme') as FormControl<boolean>;
  }

  ngOnInit(): void {
    const activeTheme = this.themeService.getActiveTheme()
    this.themeForm.patchValue({ theme: activeTheme ? true : false })
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

  toggleTheme() {
    this.themeService.setActiveTheme(this.themeControl.value);
  }


}
