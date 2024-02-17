import { Component, OnInit } from '@angular/core';
import { StudentAddService } from '../../service/student-add.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrl: './student-profile.component.css'
})
export class StudentProfileComponent implements OnInit{
  
  constructor(private studntSetvivce:StudentAddService, private route: ActivatedRoute,  private router: Router){}
  
  studentData: any;
  
  
  ngOnInit(): void {
   

    this.route.params.subscribe(params => {
      const id = params['id'];
      this.getAllById(id);
    });


  }
  getAllById(id: number): void {
    this.studntSetvivce.getAllById(id).subscribe(student => {
      this.studentData = student;
    });
  }
  deleteStudent(id: number): void {
    this.studntSetvivce.deleteStudent(id).subscribe(() => {
  
      this.router.navigateByUrl('/stview');
    });
  }
}
