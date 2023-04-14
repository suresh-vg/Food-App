import { Component, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TotalPricePipe } from '../Pipes/total-price.pipe';
import { FoodProductService } from '../Services/food-product.service';
import { StaffService } from '../Services/staff.service';
import { FoodOrder } from './foodOrder';
import { Router } from '@angular/router';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css'],
})
export class StaffComponent implements OnInit {
  response: any;
  _isOrderTaken: boolean = false;
  quantity: number | undefined;
  orderTime: Date | undefined;
  foodProductSubscriber: any;
  menuData: any;
  foodProductsList: any;
  _type: string = '';
  pattern: string = '';
  error: string | undefined;
  _staffId: any = localStorage.getItem('id');
  orderedItems: any[] = [];
  foodOrder: FoodOrder = new FoodOrder('', 0, '', '', 0, "PLACED");
  types :any;
  foodOrderData: any;
  
  constructor(
    private service: StaffService,
    private totalPrice: TotalPricePipe,
    private foodProducts: FoodProductService,
    private router:Router
  ) {}


  ngOnInit(): void {
    this.foodProductSubscriber = this.foodProducts
      .getFoodProductsByMenuId(1)
      .subscribe((response) => {
        this.foodProductsList = response;
        console.log(response);
      });
      this.getTypes();
  }

  ngOnDestroy() {
    this.foodProductSubscriber.unsubscribe();
  }


  // Creates new food order and generates id.
  createFoodOrder(order: any) {
    this.foodOrder.customerName = order.customerName;
    this.foodOrder.contactNumber = order.contactNumber;
    this.foodOrder.orderCreatedTime = new Date().toLocaleString() ;
    return this.foodOrder;
  }

  updateFoodOrder() {
    this.foodOrder.orderDeliveryTime =  new Date().toLocaleString();
    this.foodOrder.totalPrice = this.totalPrice.transform(this.orderedItems);
    this.foodOrder.status = 'PLACED';
    this.service
      .updateFoodOrder(
        this.foodOrder,
        this._staffId,
        this.foodOrderData.data.id
      )
      .subscribe((response) => {
        this.response = response;

        if(this.response.data == null){
          this.error = this.response.msg;
        }
        if(this.response.data != null){
          this.router.navigate(["foodorders",this._staffId])
        }
        console.log(this.response)
      });
  }

  plus(id: any) {
    this.orderedItems[id].quantity += 1;
  }

  minus(id: any) {
    if (this.orderedItems[id].quantity < 2) {
      this.orderedItems.splice(id, 1);
    }
    this.orderedItems[id].quantity -= 1;
  }
  
  remove(id:any){
    this.orderedItems.splice(id, 1);
  }
  
  
  addItem(id: any) {
    this.foodProductsList.data.find((product:any) => {
      if(product.id === id){
        if(this.orderedItems.find(order => order.name.toLowerCase() === product.name.toLowerCase())){
          this.error = "Item already present"
        }
        else{
          this.orderedItems.push({
            name: product.name,
            price: product.price,
            quantity: 1,
            type: product.type,
          });
        }
      }
    }) 
     
    // this.foodProductsList.data.filter((item: any) => {
    //   if (item.id === id) {
    //     this.orderedItems.push({
    //       name: item.name,
    //       price: item.price,
    //       quantity: 1,
    //       type: item.type,
    //     });
    //   }
    // });
  }



  /**  After filling the form of Customer name and number */
  foodOrders(order: NgForm) {
    // Change orderTaken value
    console.log(order.value);

    // Staff services create's new food order with customer name and customer number
    this.service
      .addNewOrder(this.createFoodOrder(order.value), this._staffId)
      .subscribe((data) => {
        this.foodOrderData = data;

        this._isOrderTaken = !this._isOrderTaken;
        console.log('Order Has been Taken ' + this.foodOrderData.data.id);
        console.log('Name ' + this.foodOrderData.data.name);
      });
  }

  postOrder() {
    this.foodOrder.totalPrice = this.totalPrice.transform(this.orderedItems);
    this.service
      .addOrderItems(this.orderedItems, this.foodOrderData.data.id)
      .subscribe((data) => {
        console.log(data);
      });
    this.updateFoodOrder();
  }

  getTypes(){
    this.foodProducts.getDistinctTypes().subscribe((response)=>{
     this.types = response
     this.types = this.types.data
   })
 }

}
