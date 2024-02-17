import { Component, OnInit } from '@angular/core';
import { SubjectName } from '../../model/subject.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SubjectService } from '../../service/subject.service';

@Component({
  selector: 'app-subject-add',
  templateUrl: './subject-add.component.html',
  styleUrl: './subject-add.component.css'
})
export class SubjectAddComponent implements OnInit{


  subjectName: SubjectName=new SubjectName();
  formValue!: FormGroup;
subjectData!: SubjectName[];

  constructor(private formBuilder: FormBuilder, private subjectService: SubjectService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      subName: [''],
     
    });
    this.getAll();
  }

  savesub(): void {

    this.subjectName.subName = this.formValue.value.subName;
    

    this.subjectService.saveSubject(this.subjectName)
    .subscribe(
      res => {
        console.log(res);
        alert("Student Added Successfully");
        this.formValue.reset();
        this.getAll();
      },
      err => {
        alert("Data Not Saved");
      }
    );
 


  }


  getAll(): void {
    this.subjectService.getAllSubjects()
      .subscribe(res => {
        this.subjectData = res;     
      });
  }


  deleteSub(row: any): void {
    this.subjectService.deleteSubject(row.subid)
      .subscribe(res => {
        console.log(res);
        alert("Data Not found")
      },
      err => {
        alert("Subject Deleted")
        this.formValue.reset();
        this.getAll();      
      });      
  }

  
  enableEdit(row: any): void {
    row.isEditing = true;
  }

  cancelEdit(row: any): void {
    row.isEditing = false;
    row.updatedName = row.subName; // Reset updated name
  }

  updateSub(row: any): void {
    const updatedSubject: SubjectName = {
      subid: row.subid,
      subName: row.updatedName
    };
    this.subjectService.updateSubject(row.subid, updatedSubject).subscribe(res => {
      console.log(res);
      alert("Subject Updated");
      row.isEditing = false;
      row.subName = row.updatedName; // Update displayed name
    },
    err => {
      alert("Data Not updated");
    });
  }




}


