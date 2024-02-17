import { TestBed } from '@angular/core/testing';

import { TeacherAddService } from './teacher-add.service';

describe('TeacherAddService', () => {
  let service: TeacherAddService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TeacherAddService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
