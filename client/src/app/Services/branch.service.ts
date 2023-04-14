import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';

@Injectable({
  providedIn: 'root'
})
export class BranchService {

  
 

  constructor(private http:HttpClient) { }

  getMenuId(id:any){
    return this.http.get(Urls.menuUrl+`${id}`);
  }

  addFoodProduct(foodProduct : any,menu_id :any){
    return this.http.post(Urls.saveFoodProducts+`${menu_id}`,foodProduct,{responseType : "json"});
  }

  deleteFoodProduct(id:any){
    return this.http.delete(Urls.deleteFoodProductById+`${id}`);
  }



}
