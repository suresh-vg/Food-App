import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { UserService } from '../Services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private _authService: UserService, private _router: Router){}

  canActivate(): boolean  {
    if(this._authService.loggedIn()){ return true;}
    else{ 
      this._router.navigate(["/login"])
      return false;
    }
  }
  
}
