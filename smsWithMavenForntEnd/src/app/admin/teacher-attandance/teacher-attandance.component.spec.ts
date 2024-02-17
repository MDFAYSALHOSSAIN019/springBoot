import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherAttandanceComponent } from './teacher-attandance.component';

describe('TeacherAttandanceComponent', () => {
  let component: TeacherAttandanceComponent;
  let fixture: ComponentFixture<TeacherAttandanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TeacherAttandanceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TeacherAttandanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
