import { NgIf } from '@angular/common';
import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgIf],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit, OnDestroy {
  @Input() homeName: string = '';
  sub: any;
  routeTitle!: string;
  routeIcon!: string;

  constructor (private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.data.subscribe((res) => {
      this.routeTitle = res['title'], this.routeIcon = res['icon']
    })
  
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

}
