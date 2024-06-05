import { Component } from '@angular/core';
import { ThemeService } from './core/theme/theme.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'aura-tower';

  constructor(
    private themeService: ThemeService
  ) {
    this.themeService.initialTheme()
  }


}
