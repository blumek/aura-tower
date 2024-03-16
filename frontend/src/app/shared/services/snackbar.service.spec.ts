import { TestBed } from '@angular/core/testing';

import { SnackbarService } from './snackbar.service';

describe('SnackbarService', () => {
  let service: SnackbarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SnackbarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should show snackbar', () => {
    service.openSnackBar('Test');
  });

  it('should show snackbar with action', () => {
    service.openSnackBar('Test', false);
  });

  it('should show snackbar with action', () => {
    service.openSnackBar('Test', true);
  });

});
