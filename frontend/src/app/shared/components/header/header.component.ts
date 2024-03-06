import { NgClass, NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { MatTooltipModule} from '@angular/material/tooltip';


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgFor, NgIf, NgClass, MatTooltipModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  @Input() homeName: string = '';
  menuVisible: boolean = false;
  menuElements = [
    {
      icon: 'fullscreen',
      name: 'Tryb pełnoekranowy',
      action: 'full-screen'
    },
    {
      icon: 'add',
      name: 'Dodaj urządzenie',
      action: 'add-device'
    },
    {
      icon: 'home_pin',
      name: 'Zarządaj lokalizacjami',
      action: '/main/manage-localizations'
    },
    {
      icon: 'settings',
      name: 'Ustawienia aplikacji',
      action: '/main/app-settings'
    },
    {
      icon: 'power_settings_new',
      name: 'Wyjdź z lokalizacji',
      action: '/home'
    },
  ]

  constructor (
    private router: Router,
  ) {}

  changeMenuVisible() {
    this.menuVisible = !this.menuVisible;
  }

  onMenuIteMSelected(actionName: string) {
    this.menuVisible = false;

    switch (actionName) {
      case 'full-screen':
        document.documentElement.requestFullscreen();
        this.menuElements[0] = {icon: 'fullscreen_exit', name: 'Wyjdź z trybu pełnoekranowego', action: 'full-screen-exit'}
        break;
      case 'full-screen-exit':
        document.exitFullscreen();
        this.menuElements[0] = {icon: 'fullscreen', name: 'Tryb pełnoekranowy', action: 'full-screen'}
        break;
      case 'add-device':
        console.log('open add device dialog')
        break;
      default:
        const link: string = actionName
        this.router.navigate([link]);;
    }
  }
}
