export class Urls {
  
  // User API's
  public static register: string = "http://localhost:8080/users/save";
  public static user: string = "http://localhost:8080/users/get/";
  public static login: string = "http://localhost:8080/users/auth";


  // Food Product API's
  public static saveFoodProducts:string = "http://localhost:8080/foodproducts/save/";
  public static getFoodProducts: string = 'http://localhost:8080/foodproducts/get/';
  public static getFoodProductsById:string = "http://localhost:8080/foodproducts/getbyfoodProduct/";
  public static updateFoodProductById:string = "http://localhost:8080/foodproducts/update/";
  public static deleteFoodProductById:string = "http://localhost:8080/foodproducts/delete/";

  // Menu API's
  public static menuUrl: string = "http://localhost:8080/menu/get/";


  // Food Order API's
  public static savefoodOrder: string = 'http://localhost:8080/foodorder/save/';
  public static getFoodOrder: string = 'http://localhost:8080/foodorder/get/';
  public static updateFoodOrder: string = "http://localhost:8080/foodorder/update/";
  public static deleteFoodOrder: string = "http://localhost:8080/foodorder/delete/";
  public static getTypes: string = "http://localhost:8080/foodproducts/types" 
  public static billFoodOrder: string ="http://localhost:8080/foodorder/bill/"
  
  // Items API's
  public static saveItems: string = 'http://localhost:8080/items/save/';
  public static items: string = "http://localhost:8080/items/get/";
  public static deleteItems: string = "http://localhost:8080/items/delete/";
  
  
}
