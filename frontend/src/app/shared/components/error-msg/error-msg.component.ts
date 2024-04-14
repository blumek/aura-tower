import { NgIf, NgSwitch } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { Subscription } from 'rxjs';
import { ErrorCodeEnum } from '../../enums/form';

@Component({
  selector: 'app-error-msg',
  standalone: true,
  imports: [
    NgIf,
    NgSwitch,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
  ],
  templateUrl: './error-msg.component.html',
  styleUrl: './error-msg.component.scss',
})
export class ErrorMsgComponent implements OnInit {
  @Input() control!: FormControl;
  @Input() form?: FormGroup;
  errorCode!: string;
  errorMsg!: string;
  sub!: Subscription;
  errorCodeEnum = ErrorCodeEnum;

  ngOnInit(): void {
    this.sub = this.control.statusChanges.subscribe(() => {
      this.checkErrorCode();
    });
  }

  checkErrorCode(): void {
    this.errorCode = this.control.errors
      ? Object.keys(this.control.errors)[0]
      : '';

    switch (this.errorCode) {
      case this.errorCodeEnum.required:
        this.errorMsg = 'Pole nie może być puste';
        break;
      case this.errorCodeEnum.userNameExists:
        this.errorMsg = 'Podana nazwa użytkownika już istnieje';
        break;
      default:
        this.errorMsg = '';
        break;
    }
  }
}
