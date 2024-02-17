import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SubjectName } from '../model/subject.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  baseUrl: string = "http://localhost:8082/subject";

  constructor(private http: HttpClient) { }

  saveSubject(data: SubjectName): Observable<SubjectName> {
    return this.http.post<SubjectName>(this.baseUrl, data);
  }

  getAllSubjects(): Observable<SubjectName[]> {
    return this.http.get<SubjectName[]>(this.baseUrl);
  }

  deleteSubject(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  updateSubject(id: number, data: SubjectName): Observable<SubjectName> {
    return this.http.put<SubjectName>(`${this.baseUrl}/${id}`, data);
  }
}
