import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  homeName: string = 'Domek Jordana';
  menuVisible: boolean = false;
  menuElements = [
    {
      icon: 'home_pin',
      name: 'Zarządaj lokalizacjami',
      link: '/'
    },
    {
      icon: 'settings',
      name: 'Ustawienia aplikacji',
      link: '/'
    },
    {
      icon: 'power_settings_new',
      name: 'Wyjdź z lokalizacji',
      link: '/'
    },
  ]

  changeMenuVisible() {
    this.menuVisible = !this.menuVisible;
  }
}
