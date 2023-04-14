import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Urls } from './devUrls';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  updateUser(id: any) {
    throw new Error('Method not implemented.');
  }

  constructor(private http:HttpClient) { }

  addEmployee(employee:any){
    return this.http.post(Urls.register,employee);
  }
  
  getUserByEmail(user:any){
    return this.http.post(Urls.login,user);
  }
  isEmail(email:any){
    return this.http.get("http://localhost:8080/users/email/"+`${email}`)
  }
  
  loggedIn(){
    return !!localStorage.getItem("id");
  }

  getRole(){
    return localStorage.getItem("role");
  }
  getStaff(){
    return this.http.get("http://localhost:8080/users/get");
  }

  updateStaff(user:any,id:any){
    return this.http.put("http://localhost:8080/users/update/"+`${id}`,user)
  }


}
