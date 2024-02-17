import { TestBed } from '@angular/core/testing';

import { ResultAddService } from './result-add.service';

describe('ResultAddService', () => {
  let service: ResultAddService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResultAddService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
