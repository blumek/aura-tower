import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private darkThemeClass = 'theme-dark';

  initialTheme(): void {
    const activeTheme = this.getActiveTheme()

    if (activeTheme) {
      document.body.classList.add(activeTheme)
    };
  }

  setActiveTheme(activeDarkTheme: boolean): void {
    if (activeDarkTheme) {
      localStorage.setItem('themePreference', this.darkThemeClass);
      document.body.classList.add(this.darkThemeClass)
    } else {
      localStorage.removeItem('themePreference');
      document.body.classList.remove(this.darkThemeClass)
    }
  }

  getActiveTheme(): string {
    const savedTheme = localStorage.getItem('themePreference')
    
    return savedTheme ? savedTheme : ''
  }

  saveActiveTheme(activeTheme: string): void {
    localStorage.setItem('themePreference', 'dark-theme');
  }
}
