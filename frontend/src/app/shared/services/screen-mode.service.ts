import { Injectable, NgZone } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ScreenModeService {
  private fullscreenChange: Subject<boolean> = new Subject<boolean>();

  constructor(private zone: NgZone) {
    this.addFullscreenEventListeners();
  }

  get fullscreenChange$() {
    return this.fullscreenChange.asObservable();
  }

  private addFullscreenEventListeners() {
    document.addEventListener(
      'fullscreenchange',
      this.fullscreenChangeHandler.bind(this)
    );
    document.addEventListener(
      'webkitfullscreenchange',
      this.fullscreenChangeHandler.bind(this)
    );
    document.addEventListener(
      'mozfullscreenchange',
      this.fullscreenChangeHandler.bind(this)
    );
    document.addEventListener(
      'MSFullscreenChange',
      this.fullscreenChangeHandler.bind(this)
    );
  }

  private fullscreenChangeHandler() {
    this.zone.run(() => {
      this.fullscreenChange.next(this.isFullscreen());
    });
  }

  private isFullscreen(): boolean {
    return !!(
      document.fullscreenElement ||
      (document as any).webkitFullscreenElement ||
      (document as any).mozFullScreenElement ||
      (document as any).msFullscreenElement
    );
  }
}
