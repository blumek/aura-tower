import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EditAuthDialogComponent } from '../../../shared/components/dialogs/edit-auth-dialog/edit-auth-dialog.component';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { ReminderQuestions } from '../../auth/models/auth';
import { ChangePasswordDialogComponent } from '../../../shared/components/dialogs/change-password-dialog/change-password-dialog.component';
import { ThemeService } from '../../../core/theme/theme.service';
import { EditRemindQuestionDialogComponent } from '../../../shared/components/dialogs/edit-remind-question-dialog/edit-remind-question-dialog.component';
import { JwtTokenService } from '../../auth/services/jwt-token.service';

@Component({
  selector: 'at-settings',
  templateUrl: './settings.component.html',
  styleUrl: '../base.component.scss'
})
export class SettingsComponent implements OnInit {
  loading: boolean = false;
  appVersion: string = '1.0.0';
  javaVersion: string = '21.0.0';
  angularVersion: string = '17.2.3';
  username: string | null = ''
  themeForm: FormGroup<{theme: FormControl<boolean | null>}> = this.fb.group({
    theme: [false],
  })
  reminderQuestionsList$!: Observable<ReminderQuestions[]>

  constructor(
    private themeService: ThemeService,
    private jwtTokenService: JwtTokenService,
    private fb: FormBuilder,
    private location: Location,
    private matDialog: MatDialog
  ) { }

  get themeControl(): FormControl<boolean> {
    return this.themeForm.get('theme') as FormControl<boolean>;
  }

  ngOnInit(): void {
    this.username = this.jwtTokenService.getUserName();
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
        const remindQuestionDialog = this.matDialog.open(EditRemindQuestionDialogComponent)
      }
    })
  }

  openChangePasswordDialog(): void {
    const dialog = this.matDialog.open(ChangePasswordDialogComponent)
  }


  toggleTheme() {
    this.themeService.setActiveTheme(this.themeControl.value);
  }


}
