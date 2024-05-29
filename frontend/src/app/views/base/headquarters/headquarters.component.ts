import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../auth/services/authentication.service';
import { CommandCenter, CommandCenterEdit, ConfigModeTypes } from '../models/comand-center';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { CommandCenterService } from '../services/command-center.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';

@Component({
  selector: 'at-headquarters',
  templateUrl: './headquarters.component.html',
  styleUrl: '../base.component.scss',
})
export class HeadquartersComponent implements OnInit {
  configMode: boolean = false;
  data$!: Observable<CommandCenter[]>
  commandCenters: CommandCenter[] = [] 
  configModeTypes = ConfigModeTypes

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private commandCenterService: CommandCenterService,
    private snackBarService: SnackbarService
  ) {}

  ngOnInit(): void {
    this.getCommandCenters()
  }

  getCommandCenters(): void {
    this.data$ = this.commandCenterService.fetchCommandCenters().pipe(
      tap((resp: CommandCenter[]) => {
        this.commandCenters = resp;
      }),
      catchError(err => {
        this.snackBarService.openSnackBar(err.error.message, true);
        
        return throwError(() => err);
      })
    )
  }

  addNewManagementCenter(): void {
    this.configMode = true;
    this.commandCenters.push({
      name: 'New',
      icon: 'question_mark',
      configModeType: this.configModeTypes.config,
    });
  }

  cancelConfigMode(cancelFromAddMode: boolean): void {
    this.configMode = false;

    if (cancelFromAddMode) {
      this.commandCenters.pop();
    }
  }

  saveConfigMode(saveFromConfig: CommandCenterEdit): void {
    if(saveFromConfig.addingMode) {
      const newCenter = {
        name: saveFromConfig.centerName,
        icon: 'HOME',
      }

      this.commandCenterService.createCommandCenter(newCenter).subscribe({
        next: () => {
          this.snackBarService.openSnackBar('New command center added', false);
          this.configMode = false;
          this.refresh()
        },
        error: (err) => {
          this.snackBarService.openSnackBar('Error occured', true);
        }        
      })
    }
  }

  refresh(): void {
    this.getCommandCenters()
  }

  goToSettings(): void {
    this.router.navigate(['base/settings']);
  }

  logout(): void {
    this.authService.logout();
  }
}
