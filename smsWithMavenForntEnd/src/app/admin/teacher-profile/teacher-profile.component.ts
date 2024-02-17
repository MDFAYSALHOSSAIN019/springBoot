import { Component, OnInit } from '@angular/core';
import { TeacherAddService } from '../../service/teacher-add.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-teacher-profile',
  templateUrl: './teacher-profile.component.html',
  styleUrl: './teacher-profile.component.css'
})
export class TeacherProfileComponent implements OnInit{
  constructor(private teacherSetvivce:TeacherAddService, private route: ActivatedRoute,  private router: Router){}
  
  teacherData: any;
  
  
  ngOnInit(): void {
   

    this.route.params.subscribe(params => {
      const id = params['id'];
      this.getAllById(id);
    });


  }
  getAllById(id: number): void {
    this.teacherSetvivce.getAllById(id).subscribe(student => {
      this.teacherData = student;
    });
  }
  deleteStudent(id: number): void {
    this.teacherSetvivce.deleteTeacher(id).subscribe(() => {
  
     this.router.navigate(['/teview']);
    });
  }
}
