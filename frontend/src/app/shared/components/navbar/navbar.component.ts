import { NgClass, NgFor, NgIf, NgStyle } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { MatTooltipModule} from '@angular/material/tooltip';
import { MenuComponent } from '../menu/menu.component';
import { menuElements, menuLocalizations } from '../../mocks/menu';
import { MatDividerModule } from '@angular/material/divider';
import { DevicesService } from '../../services/devices.service';
import { AvatarComponent } from '../avatar/avatar.component';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { Router } from '@angular/router';
import { ActionName, IMenu } from '../../models/menu';


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [NgFor, NgIf, NgClass, NgStyle, MatTooltipModule, MenuComponent, MatDividerModule, AvatarComponent, MatMenuModule, MatIconModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {
  @Output() closeNavBar = new EventEmitter<boolean>();
  navBarVisible: boolean = true;
  menuVisible: boolean = false;
  locationMenuVisible: boolean = false;
  isFullScreen: boolean = false;
  menuElements: IMenu[] = menuElements
  mockLocalizationData = menuLocalizations

  constructor(
    private router: Router,
    private devicesService: DevicesService
  ){}

  changeMenuVisible() {
    this.menuVisible = !this.menuVisible;
    this.locationMenuVisible = false;
  }

  changeLocationMenuVisible() {
    this.locationMenuVisible = !this.locationMenuVisible;
    this.menuVisible = false;
  }

  changeNavBarVisible() {
    this.navBarVisible = !this.navBarVisible;
    this.closeNavBar.emit(!this.navBarVisible);
  }

  openAddDeviceDialog() {
    this.devicesService.openAddDeviceDialog();
  }

  onMenuItemSelected(actionName: string) {
    switch (actionName) {
      case 'full-screen':
        document.documentElement.requestFullscreen();
        this.menuElements[0] = {icon: 'fullscreen_exit', name: 'Wyjdź z trybu pełnoekranowego', action: ActionName['fullscreenExit'], id: 1}
        break;
      case 'full-screen-exit':
        document.exitFullscreen();
        this.menuElements[0] = {icon: 'fullscreen', name: 'Tryb pełnoekranowy', action: ActionName['fullscreen'], id: 1}
        break;
      case 'add-device':
        this.devicesService.openAddDeviceDialog();
        break;
      case 'show-hide-nav':
        this.changeNavBarVisible()
        break;
      case 'logout':
        console.log('logout')
        break;
      default:
        const link: string = actionName
        this.router.navigate(['main/', link]);
    }
  }

  findItem(id: number): string | number {
    const foundItem = this.menuElements.find(item => item.id === id)?.action;
    return foundItem ? foundItem : id;
  }
}
