import { NgClass, NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { MatTooltipModule} from '@angular/material/tooltip';
import { MenuComponent } from '../menu/menu.component';


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgFor, NgIf, NgClass, MatTooltipModule, MenuComponent],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  @Input() homeName: string = '';
  menuVisible: boolean = false;
  locationMenuVisible: boolean = false;
  isFullScreen: boolean = false;

  menuElements = [
    {
      icon: 'fullscreen',
      name: 'Tryb pełnoekranowy',
      action: 'full-screen',
      id: 1
    },
    {
      icon: 'add',
      name: 'Dodaj urządzenie',
      action: 'add-device',
      id: 2
    },
    {
      icon: 'home_pin',
      name: 'Zarządaj otoczeniem',
      action: '/main/manage-localizations',
      id: 3
    },
    {
      icon: 'settings',
      name: 'Ustawienia aplikacji',
      action: '/main/app-settings',
      id: 4
    },
    {
      icon: 'power_settings_new',
      name: 'Wyjdź z lokalizacji',
      action: '/',
      id: 5
    },
  ]

  mockLocalizationData = [
    {
      name: 'Salon',
      icon: 'chair',
      id: 1
    },
    {
      name: 'Kuchnia',
      icon: 'oven_gen',
      id: 2,
    },
  ]

  changeMenuVisible() {
    this.menuVisible = !this.menuVisible;
    this.locationMenuVisible = false;
  }

  changeLocationMenuVisible() {
    this.locationMenuVisible = !this.locationMenuVisible;
    this.menuVisible = false;
  }
}
