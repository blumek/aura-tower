import { NgClass, NgFor, NgIf } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DisplayType } from '../../models/menu';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [NgFor, NgIf, NgClass],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {
  @Input() isAreaChangeMenu: boolean = false;
  @Input() menuItems: any[] = [];
  @Output() menuItemSelected = new EventEmitter<string>();
  displayTypeDesktop: DisplayType = DisplayType.desktop;
  
  onMenuIteMSelected(actionName: string) {
    this.menuItemSelected.emit(actionName);
  }
}
