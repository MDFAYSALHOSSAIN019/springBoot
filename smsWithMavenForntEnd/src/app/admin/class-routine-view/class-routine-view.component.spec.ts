import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassRoutineViewComponent } from './class-routine-view.component';

describe('ClassRoutineViewComponent', () => {
  let component: ClassRoutineViewComponent;
  let fixture: ComponentFixture<ClassRoutineViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ClassRoutineViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ClassRoutineViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
