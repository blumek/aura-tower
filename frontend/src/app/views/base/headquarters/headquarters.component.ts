import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../auth/services/authentication.service';
import { CommandCenter, ConfigModeTypes } from '../models/comand-center';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { CommandCenterService } from '../services/command-center.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';

@Component({
  selector: 'at-headquarters',
  templateUrl: './headquarters.component.html',
  styleUrl: './headquarters.component.scss',
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

  logout(): void {
    this.authService.logout();
  }

  goToSettings(): void {
    this.router.navigate(['base/settings']);
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

  saveConfigMode(saveFromConfig: any): void {
    if(saveFromConfig.addingMode) {
      this.commandCenters[this.commandCenters.length - 1] = {
        id: 'new-element',
        name: saveFromConfig.centerName,
        icon: saveFromConfig.centerIcon,
        configModeType: this.configModeTypes.normal
      }
      this.configMode = false;
      console.log(this.commandCenters);
    }
  }
}
