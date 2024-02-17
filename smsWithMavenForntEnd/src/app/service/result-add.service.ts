import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResultAddModel } from '../model/result.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResultAddService {



  constructor(private http:HttpClient) { }



  baseURl:string="http://localhost:8082/result";

saveResult(data:ResultAddModel):Observable<ResultAddModel>{
  return this.http.post<ResultAddModel>(this.baseURl,data);

}

getAllResult(): Observable<ResultAddModel[]>{
  return this.http.get<ResultAddModel[]>(this.baseURl)

}

deleteResult(id:number):Observable<void>{
  return this.http.delete<void>(`${this.baseURl}/${id}`);
  
}

updateResult(id:number, data:ResultAddModel):Observable<ResultAddModel>{
  return this.http.put<ResultAddModel>(`${this.baseURl}/${id}`,data);

}








}
