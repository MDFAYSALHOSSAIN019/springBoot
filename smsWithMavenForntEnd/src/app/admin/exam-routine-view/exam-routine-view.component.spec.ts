import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamRoutineViewComponent } from './exam-routine-view.component';

describe('ExamRoutineViewComponent', () => {
  let component: ExamRoutineViewComponent;
  let fixture: ComponentFixture<ExamRoutineViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ExamRoutineViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExamRoutineViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
