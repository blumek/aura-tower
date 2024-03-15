import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackbarComponent } from '../components/snackbar/snackbar.component';


@Injectable({
  providedIn: 'root'
})
export class SnackbarService {
  constructor(private snackBar: MatSnackBar) {}

  openSnackBar(message: string,  error?: boolean,) {
    this.snackBar.openFromComponent(SnackbarComponent, {
      data: {
        message: message,
        error: error ? error : false
      },
      panelClass: error ? "at-snackbar-error" : "at-snackbar-success",
      horizontalPosition: 'end',
      duration: 500000,
    });
  }
}