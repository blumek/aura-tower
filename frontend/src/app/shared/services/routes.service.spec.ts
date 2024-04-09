import { TestBed } from '@angular/core/testing';

import { RoutesService } from './routes.service';

describe('RoutesService', () => {
  let service: RoutesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoutesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
