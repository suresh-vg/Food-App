import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';

@Injectable({
  providedIn: 'root',
})
export class StaffService {
  constructor(private http: HttpClient) {}


  // Save Food Order by staff id.
  addNewOrder(order: any,staffId:any) {
    // console.log(order)
    return this.http.post(Urls.savefoodOrder+`${staffId}`, order);
  }

  addOrderItems(items: any,foodOrderId: number) {
    return this.http.post(Urls.saveItems+`${foodOrderId}`, items);
  }

  updateFoodOrder(item:any,staffId:any,foodOrderId:number){
    return this.http.put(Urls.updateFoodOrder+`${staffId}`+"/"+`${foodOrderId}`,item)
  }

  getFoodOrderByStaffId(){
    return this.http.get(Urls.getFoodOrder+`${localStorage.getItem("id")}`)
  }

  getFoodOrderById(id:any){
    return this.http.get(Urls.billFoodOrder+`${id}`)
  }

  getAllFoodOrders(){
    return this.http.get("http://localhost:8080/foodorder/get")
  }
  getCountOfFoodOrders(id:any){
    return this.http.get("http://localhost:8080/foodorder/total-count/"+`${id}`)
  }
  getCountOfStatus(value:any){
    return this.http.get("http://localhost:8080/foodorder/count-status/"+`${value}`)
  }

}
