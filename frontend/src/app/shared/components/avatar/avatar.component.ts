import { NgClass } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-avatar',
  standalone: true,
  imports: [NgClass],
  templateUrl: './avatar.component.html',
  styleUrl: './avatar.component.scss'
})
export class AvatarComponent {
  @Input() size: number = 50;
  @Input() sourceName!: string;
  @Input() hover: boolean = false;

  initials!: string;
  color!: string;
  fullName!: string[];

  ngOnInit(): void {
    if (this.sourceName) {
      this.fullName = this.sourceName.split(' ');
      this.generateColor();
      this.generateInitials();
    } else {
      this.color = '#fff';
      this.initials = '?';
    }
  }

  generateColor() {
    let hash = 0;
    const str = this.sourceName;
  
    for (let i = 0; i < str.length; i++) {
      hash = str.charCodeAt(i) + ((hash << 2) - hash);
    }
  
    let color = '#';
    for (let i = 0; i < 3; i++) {
      let value = (hash >> (i * 8)) & 0xff;
      value = Math.min(value + 100, 200);
      color += value.toString(16).padStart(2, '0');
    }
  
    this.color = color;
  }

  generateInitials() {
    if (this.fullName && this.fullName.length > 0) {
      this.initials = this.fullName
        .slice(0, 2)
        .filter(string => string.length > 0)
        .map(string => string[0])
        .join('');
    }
  }
}
