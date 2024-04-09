import { Injectable } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { BehaviorSubject, filter } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoutesService {
  private urlTitle!: string;
  pageData = new BehaviorSubject<{title: string, icon: string}>({title: '', icon: ''})

  constructor(private router: Router) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
        this.updateUrlTitle();
    })
  }

  updateUrlTitle(): void {
    this.urlTitle = this.router.url.substring(6);
    this.getPageData(this.urlTitle);
  }

  getPageData(urlTitle: string): void {
    let pageTitle = '';
    let pageIcon = '';

    switch (urlTitle) {
      case 'dashboard':
        pageTitle = 'Panel główny';
        pageIcon = 'dashboard';
        break;
      case 'settings':
        pageTitle = 'Ustawienia';
        pageIcon = 'settings';
        break;
      default:
        pageTitle = 'Panel główny';
        pageIcon = 'dashboard';
        break;
    }

    this.pageData.next({title: pageTitle, icon: pageIcon});
  }
}
