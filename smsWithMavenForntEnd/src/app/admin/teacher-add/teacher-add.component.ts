import { Component, OnInit } from '@angular/core';
import { TeacherModel } from '../../model/teacher.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TeacherAddService } from '../../service/teacher-add.service';

@Component({
  selector: 'app-teacher-add',
  templateUrl: './teacher-add.component.html',
  styleUrl: './teacher-add.component.css'
})
export class TeacherAddComponent implements OnInit{

  teacherModel: TeacherModel = new TeacherModel();
  formValue!: FormGroup;

  constructor(private formBuilder: FormBuilder, private teacherService: TeacherAddService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      tname: [''],
      temail: [''],
      tpassword: [''],
      tphone: [''],
      tfathersname: [''],
      tmothersname: [''],
      tgender: [''],
      tdob: [''],
      tjoiningDate: [''],
      tsalary: [''],
      trole: [''],
      tdesignation: [''],
      tphoto: [''],
      tcv: ['']
    });
  }

  saveTeacher(): void {
    this.teacherModel = this.formValue.value;
    this.teacherModel.tpassword = "1234";
    this.teacherModel.trole = "2"; // Assuming default role value
    this.teacherService.saveTeacher(this.teacherModel)
      .subscribe(
        res => {
          console.log(res);
          alert("Teacher Added Successfully");
          this.formValue.reset();
        },
        err => {
          alert("Data Not Saved");
        }
      );
  }
}