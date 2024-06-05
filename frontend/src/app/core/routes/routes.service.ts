import { Injectable } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { BehaviorSubject, filter, tap } from 'rxjs';

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
    this.urlTitle = this.router.url;

    this.getPageData(this.urlTitle);
  }

  getPageData(urlTitle: string): void {
    let pageTitle = '';
    let pageIcon = '';

    switch (urlTitle) {
      case '/base/headquarters':
        pageTitle = 'Select your Aura Tower management center';
        pageIcon = 'home_pin';
        break;
      case '/main/dashboard':
        pageTitle = 'Dashboard';
        pageIcon = 'dashboard';
        break;
      case '/base/settings':
        pageTitle = 'Settings';
        pageIcon = 'settings';
        break;
      default:
        pageTitle = 'Dashboard';
        pageIcon = 'dashboard';
        break;
    }

    this.pageData.next({title: pageTitle, icon: pageIcon});
  }
}
