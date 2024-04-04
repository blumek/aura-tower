import { NgIf } from '@angular/common';
import {
  Component,
  Input,
  OnDestroy,
  OnInit,
} from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Subscription } from 'rxjs';

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
  sub!: Subscription;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.getPageTitle(this.router.url.substring(6));

    this.sub = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.updateUrlTitle();
      }
    });
  }

  updateUrlTitle(): void {
    this.urlTitle = this.router.url.substring(6);
    this.getPageTitle(this.urlTitle);
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
