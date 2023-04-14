import { NgForOf } from '@angular/common';
import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';
import { JwtClientService } from '../Services/jwt-client.service';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  response: any;
  isinvalidLogin = true;
@ViewChild(NavbarComponent) navbarComponent:NavbarComponent | undefined;
  
  constructor(private service: UserService,private router:Router) {}

  ngOnInit(): void {}

  error: String = '';

  doLogin(employee: NgForm) {

    this.service.getUserByEmail(employee.value).subscribe((response) => {
      this.response = response;
      console.log(response)
      // Alert for wrong email.
      if (this.response.data == null) {
        this.error = "Invalid Credentials";
      }

      if(!this.response.data.active){
        this.error = "Your account has beend de-Activated. Please Contact ADMIN";
      }
      
      // // Alert for wrong password.
      // if(this.response.data.password !== employee.value.password){
      //   this.error = "Invalid Password.";
      // }

      // storing the data in localstorage.
      if(this.response.data.password == employee.value.password && this.response.data.active){
        localStorage.setItem("id",this.response.data.id)
        localStorage.setItem("role",this.response.data.role)
        this.isinvalidLogin = !this.isinvalidLogin
        this.router.navigate((this.response.data.role == "ADMIN")?["/menu",this.response.data.id]:["/foodorders",this.response.data.id])
      }

    });
  }
}
