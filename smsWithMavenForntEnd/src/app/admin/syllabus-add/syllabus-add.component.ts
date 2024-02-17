import { Component } from '@angular/core';
import { SyllabusModel } from '../../model/syllabus.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SyllabusAddService } from '../../service/syllabus-add.service';
import { SubjectName } from '../../model/subject.model';
import { SubjectService } from '../../service/subject.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-syllabus-add',
  templateUrl: './syllabus-add.component.html',
  styleUrl: './syllabus-add.component.css'
})
export class SyllabusAddComponent {

  formValue ! : FormGroup;
  syllabus: SyllabusModel = new SyllabusModel(); 
  syllabusData: any[]=[];
  subjects:SubjectName[]=[];

  constructor(
     private formBuilder: FormBuilder,
     private syllabusService: SyllabusAddService,
     private subjectservice:SubjectService
     ) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      sclass: ['', Validators.required],
      examCatagory: ['', Validators.required],
      // examCatagory: ['', [Validators.required, Validators.email]],
      pageNo: ['', Validators.required],
      discription: ['', Validators.required],      
      subjectModel: [null] // Assuming you have a department dropdown
    });

    
    this.loadSubject();
    this.loadSyllabus();
   this.getAll();
  }

  private loadSyllabus(){
    this.syllabusService.getAllSyllabus().subscribe(
      data => this.syllabusData = data,
      error => console.error('Error fetching Syllabus', error)
    );

  }
  private loadSubject() {
    this.subjectservice.getAllSubjects().subscribe(
      data => this.subjects = data,
      error => console.error('Error fetching subject', error)
    );
  }
 
  getAllSyllabus(){
    this.syllabusService.getAllSyllabus()
    .subscribe(
      res=>{
        this.syllabusData=res;
      },
      error => {
        console.error('Error fetching house data:', error);
      }
    );
  }


  
  setSyllabusModelFromForm(): void {
    this.syllabus.sclass =this.formValue.value.sclass;
    this.syllabus.examCatagory =this. formValue.value.examCatagory;
    this.syllabus.pageNo = this.formValue.value.pageNo;
    this.syllabus.discription = this.formValue.value.discription;
    this.syllabus.subjectModel = {
      subName: this.formValue.value.subjectModel
    };
  }

  // onSubmit() {
  //   if (this.formValue.valid) {
  //     const syllabusData: SyllabusModel = this.formValue.value;

  //     this.syllabusService.saveSyllabus(syllabusData).subscribe(
  //       response => {
  //         console.log('Syllabus created successfully', response);
  //         this.loadSyllabus(); // Refresh the list of employees after creation
  //         this.formValue.reset(); // Reset the form
  //       },
  //       error => alert('Error creating Syllabus')
  //     );
  //   }
  // }


  saveSyllabus() {

    this.setSyllabusModelFromForm();

    this.syllabusService.saveSyllabus(this.syllabus)
      .subscribe(
        (res) => {
          // this.getAllHouse();
          this.formValue.reset();
          alert("Syllabus Saved");
        },
        (err) => {
          console.error("Error saving syllabus:", err);
          
          alert("Syllabus Not Saved. Check console for details.");
        }
      );
  }







  // saveSyllabus(): void {
  //   this.syllabus.sclass = this.formValue.value.sclass;
  //   this.syllabus.examCatagory = this.formValue.value.examCatagory;
  //   this.syllabus.subjectModel = this.formValue.value.subject;
  //   this.syllabus.pageNo = this.formValue.value.pageNo;
  //   this.syllabus.discription = this.formValue.value.discription;


  //   this.syllabusService.saveSyllabus(this.syllabus)
  //   .subscribe(
  //     res => {
  //       console.log(res);
  //       alert("Data Not Saved");
  //     },
  //     err => {

  //       alert("syllabus Added Successfully");
  //       this.formValue.reset();
  //       // this.getAll();
      
  //     }
  //   );  
  // }


  getAll(): void {
    this.syllabusService.getAllSyllabus()
      .subscribe(res => {
        this.syllabusData = res;
      });
  }

  deleteSyllabus(row: any): void {
    this.syllabusService.deleteSyllabus(row.syid)
      .subscribe(res => {
        console.log(res);
        alert("Data Not found");
      },
      err => {
        alert("Syllabus Deleted");
        this.formValue.reset();
        this.getAll();
      });
  }




}
