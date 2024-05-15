import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../auth/services/authentication.service';

@Component({
  selector: 'at-headquarters',
  templateUrl: './headquarters.component.html',
  styleUrl: './headquarters.component.scss',
})
export class HeadquartersComponent {
  configMode: boolean = false

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {}

  logout() {
    this.authService.logout();
  }
  
  goToSettings() {
    this.router.navigate(['main/settings']);
  }
  
  setConfigMode(action?: boolean): void {
    this.configMode = !action
  }


}
