import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-intro',
  templateUrl: './intro.component.html',
  styleUrl: './intro.component.scss'
})
export class IntroComponent implements OnInit {
  @ViewChild('imgElement') imgElement!: ElementRef;

  imgSrc: string = '';
  title: string = '';
  description: string = '';
  step: number = 1;

  ngOnInit(): void {
    
  }

}
