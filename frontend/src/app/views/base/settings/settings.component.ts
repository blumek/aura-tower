import { Location } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'at-settings',
  templateUrl: './settings.component.html',
  styleUrl: '../base.component.scss'
})
export class SettingsComponent {
  loading: boolean = false;

  constructor(
    private location: Location
  ) { }

  goToHeadquarters(): void {
    this.location.back()
  }
}
