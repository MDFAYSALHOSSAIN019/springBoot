import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentPaymentReceiveComponent } from './student-payment-receive.component';

describe('StudentPaymentReceiveComponent', () => {
  let component: StudentPaymentReceiveComponent;
  let fixture: ComponentFixture<StudentPaymentReceiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudentPaymentReceiveComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StudentPaymentReceiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
