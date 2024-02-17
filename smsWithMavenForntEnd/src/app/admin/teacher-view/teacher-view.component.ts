import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeacherAddService } from '../../service/teacher-add.service';

@Component({
  selector: 'app-teacher-view',
  templateUrl: './teacher-view.component.html',
  styleUrl: './teacher-view.component.css'
})
export class TeacherViewComponent implements OnInit{

  teacherData:any;  
  
  constructor(private route:Router, private teaService:TeacherAddService){}  

  ngOnInit(): void {   
    this.getAll(); 
  }

  getAll(): void {
    this.teaService.getAllTeachers()
      .subscribe(res => {
        this.teacherData = res;     
      });
  }






}
