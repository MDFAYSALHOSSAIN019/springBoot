import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentAddComponent } from './admin/student-add/student-add.component';
import { StudentViewComponent } from './admin/student-view/student-view.component';
import { TeacherAddComponent } from './admin/teacher-add/teacher-add.component';
import { TeacherViewComponent } from './admin/teacher-view/teacher-view.component';
import { ClassRoutineAddComponent } from './admin/class-routine-add/class-routine-add.component';
import { ClassRoutineViewComponent } from './admin/class-routine-view/class-routine-view.component';
import { ExamRoutineAddComponent } from './admin/exam-routine-add/exam-routine-add.component';
import { ExamRoutineViewComponent } from './admin/exam-routine-view/exam-routine-view.component';
import { StudentResultAddComponent } from './admin/student-result-add/student-result-add.component';
import { StudentResultViewComponent } from './admin/student-result-view/student-result-view.component';
import { StudentAttandanceComponent } from './admin/student-attandance/student-attandance.component';
import { DashBoardComponent } from './admin/dash-board/dash-board.component';
import { StudentPaymentReceiveComponent } from './admin/student-payment-receive/student-payment-receive.component';
import { StudentPaymentDetailsComponent } from './admin/student-payment-details/student-payment-details.component';
import { StudentProfileComponent } from './admin/student-profile/student-profile.component';
import { TeacherProfileComponent } from './admin/teacher-profile/teacher-profile.component';
import { SyllabusAddComponent } from './admin/syllabus-add/syllabus-add.component';
import { SyllabusViewComponent } from './admin/syllabus-view/syllabus-view.component';
import { SubjectAddComponent } from './admin/subject-add/subject-add.component';
import { SubjectViewComponent } from './admin/subject-view/subject-view.component';

const routes: Routes = [

  {path:"",component:DashBoardComponent},
  {path:"stadd",component:StudentAddComponent},
  {path:"stview",component:StudentViewComponent},
  {path:"stprofile/:id",component:StudentProfileComponent},
  {path:"teadd",component:TeacherAddComponent},
  {path:"teview",component:TeacherViewComponent},
  {path:"teprofile/:id",component:TeacherProfileComponent},
  {path:"classrutineadd",component:ClassRoutineAddComponent},
  {path:"classrutineview",component:ClassRoutineViewComponent},
  {path:"examrutineadd",component:ExamRoutineAddComponent},
  {path:"examrutineview",component:ExamRoutineViewComponent},
  {path:"resultadd",component:StudentResultAddComponent},
  {path:"resultview",component:StudentResultViewComponent},
  {path:"stattendanceadd",component:StudentAttandanceComponent},
  {path:"stpayment",component:StudentPaymentReceiveComponent},
  {path:"stpaymentview",component:StudentPaymentDetailsComponent},
  {path:"syllabusadd",component:SyllabusAddComponent},
  {path:"syllabusview",component:SyllabusViewComponent},
  {path:"subjectadd",component:SubjectAddComponent},
  {path:"subjectview",component:SubjectViewComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
