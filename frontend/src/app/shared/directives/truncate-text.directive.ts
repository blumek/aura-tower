import { AfterViewInit, Directive, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appTruncateText]',
  standalone: true,
})
export class TruncateTextDirective implements AfterViewInit {
  @Input('appTruncateText') truncateText!: number

  constructor(
    private el: ElementRef,
    private renderer: Renderer2) { }

    ngAfterViewInit() {
      const text = this.el.nativeElement.textContent.trim();
      const truncatedText = this.getTruncatedText(text);
      
      if (text.length > this.truncateText) {
        this.renderer.setProperty(this.el.nativeElement, 'textContent', truncatedText);
        this.el.nativeElement.setAttribute(`matTooltip`, text);
        console.log(this.el.nativeElement);
      }
    }

    getTruncatedText(text: string): string {
      return text.length <= this.truncateText ? text : `${text.substring(0, this.truncateText)}...`;
    }

}
