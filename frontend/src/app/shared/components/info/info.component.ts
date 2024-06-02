import { NgClass, NgStyle } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'at-info',
  standalone: true,
  imports: [NgClass, NgStyle],
  templateUrl: './info.component.html',
  styleUrl: './info.component.scss'
})
export class InfoComponent {
  @Input() infoText: string = '';
  @Input() border: boolean = true;
  @Input() textAlignment: string = 'left';
  @Input() width!: number
}
