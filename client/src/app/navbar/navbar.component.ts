import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  role:string|null = "";
  id :any;
  isLoggedIn :boolean = false;
  isAdmin:any;
  constructor(private router:Router,private userService:UserService) { }
  
  ngOnInit(): void {
    this.role = localStorage.getItem("role");
    this.id = localStorage.getItem("id");
    this.isLoggedIn = this.userService.loggedIn();
    this.isAdmin = (this.userService.getRole() === "ADMIN")?true:false;
    console.log(this.isLoggedIn,this.isAdmin)
  }


  logout(){
    localStorage.clear()
    this.router.navigate(["login"])
  }


}
