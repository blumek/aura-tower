import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../auth/services/authentication.service';

@Component({
  selector: 'at-headquarters',
  templateUrl: './headquarters.component.html',
  styleUrl: './headquarters.component.scss',
})
export class HeadquartersComponent implements OnInit {
  configMode: boolean = false;
  managementCenters: any = [
    {
      name: 'Home',
      icon: 'home',
      id: 1,
    },
  ];

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {}

  ngOnInit(): void {}

  logout() {
    this.authService.logout();
  }

  goToSettings() {
    this.router.navigate(['main/settings']);
  }

  addNewManagementCenter() {
    this.configMode = true;
    this.managementCenters.push({
      name: 'New',
      icon: 'question_mark',
      configMode: true,
    });
  }

  cancelConfigMode(cancelFromAddingMode: boolean) {
    this.configMode = false;

    if (cancelFromAddingMode) {
      this.managementCenters.pop();
    }
  }
}
