import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SyllabusViewComponent } from './syllabus-view.component';

describe('SyllabusViewComponent', () => {
  let component: SyllabusViewComponent;
  let fixture: ComponentFixture<SyllabusViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SyllabusViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SyllabusViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
