import { Component, OnInit } from '@angular/core';
import { StudntAddForm } from '../../model/student.model';
import { Router } from '@angular/router';
import { StudentAddService } from '../../service/student-add.service';

@Component({
  selector: 'app-student-view',
  templateUrl: './student-view.component.html',
  styleUrl: './student-view.component.css'
})
export class StudentViewComponent implements OnInit{

  studentData:any;  
  selectedClass?: string;



  // studentModel: StudentModel = new StudentModel();

  
  constructor(private route:Router, private stuService:StudentAddService){}
  

  ngOnInit(): void {
   
    this.getAll();
  //   this.product.popularProducts().subscribe((data)=>{
  //     this.popularProducts=data;
  //   })

  //   this.product.trendyProducts().subscribe((data)=>{
  //     this.trendyProducts=data;
  //   })

  //   let productId = this.activeRoute.snapshot.paramMap.get('productId');
  //  console.warn(productId);
 
  //  if (productId) {
  //    this.product.getProduct(productId).subscribe((result) => {
  //      this.productData = result;
  //      console.log('Product Data:', this.productData); 

  //      let user = localStorage.getItem('user');       
  //      if (user) {
  //        let userId = user && JSON.parse(user).id;
  //        this.product.getCartList(userId);
 
  //        this.product.cartData.subscribe((result) => {
  //          let item = result.filter((item: product) => productId?.toString() === item.productId?.toString());
  //          if (item.length) {
  //            this.cartData = item[0];
           
  //          }
  //        });
  //      }
  //    });
  //  }
  }



  getAll(): void {
    this.stuService.getAllStudents()
      .subscribe(res => {
        this.studentData = res;     
      });
  }
  loadStudentsByClass(stClass: string): void {
    this.selectedClass = stClass;
    this.stuService.getAllByClass(stClass)
      .subscribe(res => {
        this.studentData = res;
      });
}

  }








