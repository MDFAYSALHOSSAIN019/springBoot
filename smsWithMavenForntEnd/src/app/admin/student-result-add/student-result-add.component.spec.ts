import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentResultAddComponent } from './student-result-add.component';

describe('StudentResultAddComponent', () => {
  let component: StudentResultAddComponent;
  let fixture: ComponentFixture<StudentResultAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudentResultAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StudentResultAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
