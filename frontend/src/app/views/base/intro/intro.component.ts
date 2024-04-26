import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-intro',
  templateUrl: './intro.component.html',
  styleUrl: './intro.component.scss'
})
export class IntroComponent implements OnInit {
  @ViewChild('imgElement') imgElement!: ElementRef;

  imgSrc: string = '';
  title: string = 'Witaj w Aura Tower';
  description: string = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vulputate suscipit ultrices. Vestibulum vehicula pellentesque justo sed ultrices. Suspendisse sed vestibulum tortor, sed aliquet arcu. Praesent ornare nibh sed metus varius laoreet. Donec interdum, ipsum ut ultrices lacinia, ex enim venenatis justo, quis dictum massa lorem quis diam. Morbi nec sodales nisi, ut malesuada mi. Morbi auctor nibh vitae orci porta vulputate. Sed accumsan nulla magna. Vestibulum semper justo a odio vestibulum, vel congue arcu lobortis.';
  step: number = 1;

  ngOnInit(): void {
    
  }

}
