import { NgClass, NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatTooltipModule} from '@angular/material/tooltip';
import { MenuComponent } from '../menu/menu.component';
import { menuElements, menuLocalizations } from '../../mocks/menu';



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

  menuElements = menuElements
  mockLocalizationData = menuLocalizations

  changeMenuVisible() {
    this.menuVisible = !this.menuVisible;
    this.locationMenuVisible = false;
  }

  changeLocationMenuVisible() {
    this.locationMenuVisible = !this.locationMenuVisible;
    this.menuVisible = false;
  }
}
