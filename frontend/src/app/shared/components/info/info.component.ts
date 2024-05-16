import { NgClass } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'at-info',
  standalone: true,
  imports: [NgClass],
  templateUrl: './info.component.html',
  styleUrl: './info.component.scss'
})
export class InfoComponent {
  @Input() infoText: string = '';
  @Input() border: boolean = true;
  
}
