import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TeacherModel } from '../model/teacher.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeacherAddService {

  baseUrl: string = "http://localhost:8082/teacher";

  constructor(private http: HttpClient) { }

  saveTeacher(data: TeacherModel): Observable<TeacherModel> {
    return this.http.post<TeacherModel>(this.baseUrl, data);
  }

  getAllTeachers(): Observable<TeacherModel[]> {
    return this.http.get<TeacherModel[]>(this.baseUrl);
  }

  deleteTeacher(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  updateTeacher(id: number, data: TeacherModel): Observable<TeacherModel> {
    return this.http.put<TeacherModel>(`${this.baseUrl}/${id}`, data);
  }

  getAllById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }
  
}