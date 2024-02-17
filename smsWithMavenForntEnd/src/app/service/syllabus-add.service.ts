import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SyllabusModel } from '../model/syllabus.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SyllabusAddService {

  baseUrl: string = "http://localhost:8082/syllabus";

  constructor(private http: HttpClient) { }

  saveSyllabus(data: SyllabusModel): Observable<SyllabusModel> {
    return this.http.post<SyllabusModel>(this.baseUrl, data);
  }

  getAllSyllabus(): Observable<SyllabusModel[]> {
    return this.http.get<SyllabusModel[]>(this.baseUrl);
  }

  deleteSyllabus(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  updateSyllabus(id: number, data: SyllabusModel): Observable<SyllabusModel> {
    return this.http.put<SyllabusModel>(`${this.baseUrl}/${id}`, data);
  }
}
