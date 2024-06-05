import { TestBed } from '@angular/core/testing';

import { ScreenModeService } from './screen-mode.service';

describe('ScreenModeService', () => {
  let service: ScreenModeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScreenModeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
