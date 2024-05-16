import { TestBed } from '@angular/core/testing';

import { CommandCenterService } from './command-center.service';

describe('CommandCenterService', () => {
  let service: CommandCenterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommandCenterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
