import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Urls} from "./devUrls";
@Injectable({
  providedIn: 'root'
})
export class FoodProductService {

  constructor(private http: HttpClient) { }


  // Get food products by menu id
  getFoodProductsByMenuId(menuId: any){
    return this.http.get(Urls.getFoodProducts+`${menuId}`)
  }

  // Add Food Products By Menu Id
  addFoodproductsByMenuid(request:any,menuId:any){
    return this.http.post(Urls.saveFoodProducts+`${menuId}`,request)
  }

  // Delete Food products By food product id
  deleteFoodproductById(fooproductId:any){
    return this.http.delete(Urls.deleteFoodProductById+`${fooproductId}`)
  }

  updateFoodProduct(product:any,menu_id:any,product_id:any){
    return this.http.put(Urls.updateFoodProductById+`${menu_id}`+"/"+`${product_id}`,product)
  }
  
  getDistinctTypes(){
    return this.http.get(Urls.getTypes,{responseType:'json'});
  }
}
