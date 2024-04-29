import { NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'at-no-results',
  standalone: true,
  imports: [NgIf],
  templateUrl: './no-results.component.html',
  styleUrl: './no-results.component.scss'
})
export class NoResultsComponent {
  @Input() imgSrc!: string;
  @Input() imgAlt!: string;
  @Input() mainTitle!: string;
  @Input() description!: string;
  @Input() buttonIcon!: string;
  @Input() buttonText!: string;
  @Input() buttonAction!: () => void;

  onButtonClick(): void {
    if (this.buttonAction) {
      this.buttonAction();
    }
  }
}
