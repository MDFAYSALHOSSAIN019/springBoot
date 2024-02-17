import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './admin/header/header.component';
import { SidebarComponent } from './admin/sidebar/sidebar.component';
import { FooterComponent } from './admin/footer/footer.component';
import { StudentAddComponent } from './admin/student-add/student-add.component';
import { StudentViewComponent } from './admin/student-view/student-view.component';
import { TeacherAddComponent } from './admin/teacher-add/teacher-add.component';
import { TeacherViewComponent } from './admin/teacher-view/teacher-view.component';
import { ClassRoutineAddComponent } from './admin/class-routine-add/class-routine-add.component';
import { ClassRoutineViewComponent } from './admin/class-routine-view/class-routine-view.component';
import { ExamRoutineAddComponent } from './admin/exam-routine-add/exam-routine-add.component';
import { ExamRoutineViewComponent } from './admin/exam-routine-view/exam-routine-view.component';
import { StudentAttandanceComponent } from './admin/student-attandance/student-attandance.component';
import { TeacherAttandanceComponent } from './admin/teacher-attandance/teacher-attandance.component';
import { StudentResultAddComponent } from './admin/student-result-add/student-result-add.component';
import { StudentResultViewComponent } from './admin/student-result-view/student-result-view.component';
import { StudentPaymentReceiveComponent } from './admin/student-payment-receive/student-payment-receive.component';
import { StudentPaymentDetailsComponent } from './admin/student-payment-details/student-payment-details.component';
import { DashBoardComponent } from './admin/dash-board/dash-board.component';
import { StudentProfileComponent } from './admin/student-profile/student-profile.component';
import { SyllabusAddComponent } from './admin/syllabus-add/syllabus-add.component';
import { SyllabusViewComponent } from './admin/syllabus-view/syllabus-view.component';
import { SubjectAddComponent } from './admin/subject-add/subject-add.component';
import { SubjectViewComponent } from './admin/subject-view/subject-view.component';
import { TeacherProfileComponent } from './admin/teacher-profile/teacher-profile.component';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    
    HeaderComponent,
    SidebarComponent,
    FooterComponent,
    StudentAddComponent,
    StudentViewComponent,
    TeacherAddComponent,
    TeacherViewComponent,
    ClassRoutineAddComponent,
    ClassRoutineViewComponent,
    ExamRoutineAddComponent,
    ExamRoutineViewComponent,
    StudentAttandanceComponent,
    TeacherAttandanceComponent,
    StudentResultAddComponent,
    StudentResultViewComponent,
    StudentPaymentReceiveComponent,
    StudentPaymentDetailsComponent,
    DashBoardComponent,
    StudentProfileComponent,
    SyllabusAddComponent,
    SyllabusViewComponent,
    SubjectAddComponent,
    SubjectViewComponent,
    TeacherProfileComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, // Add FormsModule here
    HttpClientModule,
    ReactiveFormsModule
  ],
   
  providers: [
    provideHttpClient(
      withFetch()
    )
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
