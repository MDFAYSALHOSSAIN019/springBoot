import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassRoutineAddComponent } from './class-routine-add.component';

describe('ClassRoutineAddComponent', () => {
  let component: ClassRoutineAddComponent;
  let fixture: ComponentFixture<ClassRoutineAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ClassRoutineAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ClassRoutineAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
