import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { InfoComponent } from '../../info/info.component';
import { RemindQuestionForm } from '../../../../views/base/models/forms';
import { AuthenticationService } from '../../../../views/auth/services/authentication.service';
import { Observable } from 'rxjs';
import { ReminderQuestions } from '../../../../views/auth/models/auth';
import { LoadingComponent } from '../../loading/loading.component';
import { MatSelectModule } from '@angular/material/select';
import { AsyncPipe, NgIf } from '@angular/common';

@Component({
  selector: 'at-edit-remind-question-dialog',
  standalone: true,
  imports: [NgIf, AsyncPipe, InfoComponent, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatIconModule, LoadingComponent, MatSelectModule],
  templateUrl: './edit-remind-question-dialog.component.html',
  styleUrl: './edit-remind-question-dialog.component.scss'
})
export class EditRemindQuestionDialogComponent implements OnInit {
  reminderQuestionsList$!: Observable<ReminderQuestions[]>
  remindQuestionForm: FormGroup<RemindQuestionForm> = this.fb.group({
    auxiliaryQuestion: ['', Validators.required],
    auxiliaryAnswer: ['', Validators.required],
  })

  constructor(
    private fb: FormBuilder,
    private authService: AuthenticationService,
    private dialogRef: MatDialogRef<EditRemindQuestionDialogComponent>
  ) {}

  get auxiliaryQuestionControl(): FormControl<string> {
    return this.remindQuestionForm.get('auxiliaryQuestion') as FormControl<string>;
  }

  get auxiliaryAnswerControl(): FormControl<string> {
    return this.remindQuestionForm.get('auxiliaryAnswer') as FormControl<string>;
  }

  ngOnInit(): void {
    this.reminderQuestionsList$ = this.authService.getRemindQuestions()
  }

  changeRemindQuestion(): void {
    // TODO: Implement change remind question functionality

    this.dialogRef.close()
  }
}
