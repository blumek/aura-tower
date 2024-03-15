import { NgIf } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MAT_SNACK_BAR_DATA, MatSnackBarRef } from '@angular/material/snack-bar';
import { ISnackbar } from '../../models/snackbar';

@Component({
  selector: 'app-snackbar',
  standalone: true, 
  imports: [ MatIconModule, NgIf ],
  templateUrl: './snackbar.component.html',
  styleUrl: './snackbar.component.scss'
})
export class SnackbarComponent {
  constructor (
    public snackBarRef: MatSnackBarRef<SnackbarComponent>,
    @Inject(MAT_SNACK_BAR_DATA) public data: ISnackbar
  ) {}

}
