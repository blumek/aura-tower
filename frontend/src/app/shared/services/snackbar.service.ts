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
      },
      panelClass: error ? "at-snackbar-error" : "at-snackbar-sccess",
      horizontalPosition: 'end',
      duration: 5000,
    });
  }
}
