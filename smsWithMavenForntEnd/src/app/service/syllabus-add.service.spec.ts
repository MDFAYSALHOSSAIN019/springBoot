import { TestBed } from '@angular/core/testing';

import { SyllabusAddService } from './syllabus-add.service';

describe('SyllabusAddService', () => {
  let service: SyllabusAddService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SyllabusAddService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
