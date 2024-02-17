import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamRoutineAddComponent } from './exam-routine-add.component';

describe('ExamRoutineAddComponent', () => {
  let component: ExamRoutineAddComponent;
  let fixture: ComponentFixture<ExamRoutineAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ExamRoutineAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExamRoutineAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
