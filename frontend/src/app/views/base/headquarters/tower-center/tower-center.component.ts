import { Component, Input } from '@angular/core';

@Component({
  selector: 'at-tower-center',
  templateUrl: './tower-center.component.html',
  styleUrl: './tower-center.component.scss'
})
export class TowerCenterComponent {
  @Input() isAAddingComponent: boolean = false;
  

}
