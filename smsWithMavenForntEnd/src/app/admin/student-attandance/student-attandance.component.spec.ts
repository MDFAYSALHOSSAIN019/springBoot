import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentAttandanceComponent } from './student-attandance.component';

describe('StudentAttandanceComponent', () => {
  let component: StudentAttandanceComponent;
  let fixture: ComponentFixture<StudentAttandanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudentAttandanceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StudentAttandanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
