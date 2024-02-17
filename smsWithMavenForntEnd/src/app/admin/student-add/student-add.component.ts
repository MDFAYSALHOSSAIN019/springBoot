import { Component, OnInit } from '@angular/core';
import { StudntAddForm } from '../../model/student.model';
import { StudentAddService } from '../../service/student-add.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrl: './student-add.component.css'
})
export class StudentAddComponent implements OnInit {
 
 
  studentModel: StudntAddForm=new StudntAddForm();
  formValue!: FormGroup;
  studentData!: StudntAddForm[];

  constructor(private formBuilder: FormBuilder, private studentService: StudentAddService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      batchId: [''],
      session: [''],
      stClass: [''],
      stRoll: [''],
      stfirstname: [''],
      stlastname: [''],
      stemail: [''],
      stfathersname: [''],
      stmothersname: [''],
      stpassword: [''],
      strole: [''],
      stdob: [''],
      staddress: [''],
      stgender: [''],
      stphone: [''],
      stPhoto: ['']
    });
  }

  savestudent(): void {

    this.studentModel.batchId = this.formValue.value.batchId;
    this.studentModel.session = this.formValue.value.session;
    this.studentModel.stClass = this.formValue.value.stClass;
    this.studentModel.stRoll = this.formValue.value.stRoll;
    this.studentModel.stfirstname = this.formValue.value.stfirstname;
    this.studentModel.stlastname = this.formValue.value.stlastname;
    this.studentModel.stemail = this.formValue.value.stemail;
    this.studentModel.stfathersname = this.formValue.value.stfathersname;
    this.studentModel.stmothersname = this.formValue.value.stmothersname;
    this.studentModel.stpassword = this.formValue.value.stpassword;
    this.studentModel.strole = this.formValue.value.strole;
    this.studentModel.stdob = this.formValue.value.stdob;
    this.studentModel.staddress = this.formValue.value.staddress;
    this.studentModel.stgender = this.formValue.value.stgender;
    this.studentModel.stphone = this.formValue.value.stphone;
    this.studentModel.stPhoto = this.formValue.value.stPhoto;
    this.studentModel.stpassword = "1234";
    this.studentModel.strole = "3";

    this.studentService.saveStudent(this.studentModel)
    .subscribe(
      res => {
        console.log(res);
        alert("Student Added Successfully");
        this.formValue.reset();
        // this.getAll();
      },
      err => {
        alert("Data Not Saved");
      }
    );
 
  }

}
