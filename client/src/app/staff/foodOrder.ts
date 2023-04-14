export class FoodOrder {
  customerName: any;
  contactNumber: any;
  orderCreatedTime: any="";
  orderDeliveryTime: any="";
  totalPrice: number = 0;
  status: String = "";

  constructor(
    customerName: string,
    contactNumber: number,
    orderCreatedTime: string,
    orderDeliveryTime: string,
    totalPrice: number,
    status: string
  ) {}
}
