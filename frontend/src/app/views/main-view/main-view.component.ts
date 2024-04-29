import { Component } from '@angular/core';

@Component({
  selector: 'at-main-view',
  templateUrl: './main-view.component.html',
  styleUrl: './main-view.component.scss'
})
export class MainViewComponent {
  homeName: string = 'Domek Jordana'
  navBarClose!: boolean;

  changeNavBarVisible(value: boolean): void {
    this.navBarClose = value;
  }
}
