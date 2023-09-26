import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:9191/api/v1"

  constructor(private httpclient: HttpClient) { 

  }

  getEmployeslist(): Observable<Employee[]>{

    return this.httpclient.get<Employee[]>(`${this.baseURL}`+"/getall");

  }
  
  createEmployee(employee: Employee): Observable<Object> {
    return this.httpclient.post(`${this.baseURL}`+"/create", employee);
  }


}
