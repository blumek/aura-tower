import { NgFor, NgIf } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {
  @Input() isAreaChangeMenu: boolean = false;
  @Input() menuItems: any[] = [];
  @Output() menuItemSelected = new EventEmitter();
  
  onMenuIteMSelected(actionName: string) {
    this.menuItemSelected.emit(actionName);
  }
}
