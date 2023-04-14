import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name : string = "";
  email :any;
  password : string = "";
  role : string = "";
  result : any;
  error:any;
  
  constructor(private service:UserService,private router:Router) { }

  ngOnInit(): void {
  }

  addUser(employeeForm:NgForm){
    console.log(employeeForm.value);
    const employee = employeeForm.value;
    employee.active = true
    
    this.service.isEmail(employeeForm.value.email).subscribe((response)=>{
        this.email = response
        console.log(this.email)
        if(this.email.data != null){
          this.error = "User already exists"
          this.router.navigate(["register"])
        }else{
          this.service.addEmployee(employee).subscribe((res)=>{
            this.result = res;
            console.log(this.result);
          })
          this.router.navigate(["login"])
        }
    })
  }

}
