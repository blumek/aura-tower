import { NgClass, NgFor, NgIf, NgOptimizedImage, NgStyle } from '@angular/common';
import { Component, EventEmitter, OnDestroy, OnInit, Output } from '@angular/core';
import { MatTooltipModule} from '@angular/material/tooltip';
import { MenuComponent } from '../menu/menu.component';
import { menuElements, menuLocalizations } from '../../mocks/menu';
import { MatDividerModule } from '@angular/material/divider';
import { DevicesService } from '../../../views/main-view/services/devices.service';
import { AvatarComponent } from '../avatar/avatar.component';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { Router } from '@angular/router';
import { ActionName, DisplayType, IMenu } from '../../models/menu';
import { RoutesService } from '../../services/routes.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'at-navbar',
  standalone: true,
  imports: [NgFor, NgIf, NgClass, NgStyle, MatTooltipModule, MenuComponent, MatDividerModule, AvatarComponent, MatMenuModule, MatIconModule, NgOptimizedImage],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent implements OnInit, OnDestroy {
  @Output() closeNavBar = new EventEmitter<boolean>();
  navBarVisible: boolean = true;
  menuVisible: boolean = false;
  locationMenuVisible: boolean = false;
  isFullScreen: boolean = false;
  menuElements: IMenu[] = menuElements;
  displayTypeMobile: DisplayType = DisplayType.mobile;
  mockLocalizationData = menuLocalizations;
  pageData!: {title: string, icon: string};
  sub!: Subscription;

  constructor(
    private router: Router,
    private devicesService: DevicesService,
    private routesService: RoutesService
  ){}

  ngOnInit(): void {
    this.sub = this.routesService.pageData.subscribe((value: {title: string, icon: string}) => {
      this.pageData = value;
    });
  }

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
        this.menuElements[0] = {icon: 'fullscreen_exit', name: 'Exit fullscreen', action: ActionName.fullscreenExit, display: DisplayType.both, id: 1}
        break;
      case 'full-screen-exit':
        document.exitFullscreen();
        this.menuElements[0] = {icon: 'fullscreen', name: 'Fullscreen', action: ActionName.fullscreen, display: DisplayType.both, id: 1}
        break;
      case 'add-device':
        this.devicesService.openAddDeviceDialog();
        break;
      case 'show-hide-nav':
        this.changeNavBarVisible()
        break;
      case 'logout':
        this.router.navigate(['base/headquarters'])
        break;
      default:
        const link: string = actionName
        this.router.navigate([link]);
    }
  }

  findItem(id: number): string | number {
    const foundItem = this.menuElements.find(item => item.id === id)?.action;
    return foundItem ? foundItem : id;
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
