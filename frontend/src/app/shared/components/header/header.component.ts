import { NgIf } from '@angular/common';
import { Component, DoCheck, Input, OnChanges, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { Subscription, filter } from 'rxjs';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgIf],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent implements OnInit, OnDestroy {
  @Input() homeName: string = '';
  urlTitle!: string | undefined;
  pageTitle!: string;
  pageIcon!: string;
  sub!: Subscription

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.getPageTitle(this.router.url.substring(6))

    this.sub = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.updateUrlTitle();
      }
    })
  }

  updateUrlTitle(): void {
    const currentUrlTitle: string | undefined = this.router.url.substring(6)

    if (currentUrlTitle && currentUrlTitle != this.urlTitle) {
      this.urlTitle = currentUrlTitle;
      this.getPageTitle(currentUrlTitle);
    }
  }

  getPageTitle(urlTitle: string): void {
    switch (urlTitle) {
      case 'dashboard':
        this.pageTitle = 'Panel główny';
        this.pageIcon = 'dashboard';
        break;
      case 'settings':
        this.pageTitle = 'Ustawienia';
        this.pageIcon = 'settings';
        break;
      default:
        this.pageTitle = 'Panel główny';
        this.pageIcon = 'dashboard';
        break;
    }
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
