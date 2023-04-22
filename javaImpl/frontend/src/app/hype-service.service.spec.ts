import { TestBed } from '@angular/core/testing';

import { HypeServiceService } from './hype-service.service';

describe('HypeServiceService', () => {
  let service: HypeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HypeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
