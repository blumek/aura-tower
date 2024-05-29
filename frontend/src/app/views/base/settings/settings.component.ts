import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'at-settings',
  templateUrl: './settings.component.html',
  styleUrl: '../base.component.scss'
})
export class SettingsComponent {
  loading: boolean = false;

  constructor(
    private router: Router,
  ) { }

  goToHeadquarters(): void {
    this.router.navigate(['/base/headquarters']);
  }
}
