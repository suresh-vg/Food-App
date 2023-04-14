import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';
import { BranchService } from '../Services/branch.service';
import { FoodProductService } from '../Services/food-product.service';
import { MenuService } from '../Services/menu.service';
import { StaffService } from '../Services/staff.service';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-branch',
  templateUrl: './branch.component.html',
  styleUrls: ['./branch.component.css'],
})
export class BranchComponent implements OnInit {
  results: any;
  error: any;
  errorMessage: any;
  _userId = localStorage.getItem('id');
  _isMenu: boolean = false;
  _menuId: any;
  _type: string = '';
  foodProducts: any;
  foodProduct: any;
  foodOrders:any;
  addNewProduct: any[] = [];
  types:any;
  pattern = ""
  staffs:any;
@ViewChild(NavbarComponent) navbarComponent:NavbarComponent | undefined;

  constructor(
    private userService:UserService,
    private menuService: MenuService,
    private foodProductService: FoodProductService,
    private staffService:StaffService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.menuService.getMenuByUserId(this._userId).subscribe((response) => {
      this.foodProducts = response;
      this.foodProduct = this.foodProducts.data.foodProducts;
      this._menuId = this.foodProducts.data.id;
      this.navbarComponent?.ngOnInit();
    });

    this.userService.getStaff().subscribe((response)=>{
      this.staffs = response;
      console.log(this.staffs)
      this.staffs=this.staffs.data;
    })
    this.getTypes();
    this.getFoodOrders();
  }

  // Retrive branch Manager specific menu id
  getFoodProducts() {
    this.menuService.getMenuByUserId(this._userId).subscribe((response) => {
      this.foodProducts = response;
    });
    console.log(this.foodProducts);
    return this.foodProducts; 
  }

  // Create Menu
  createMenu(): void {
    console.log(this._userId);
    this.menuService.createMenu(this._userId).subscribe((response) => {
      console.log('Menu data :' + response.valueOf);
    });
  }

  // Get All Food Products by menu id
  getFoodProductsByMenuId() {
    this.foodProductService
      .getFoodProductsByMenuId(this._menuId)
      .subscribe((response) => {
        this.foodProducts = response;
        console.log(this.foodProducts);
      });
  }

  addFoodProduct(foodProdut: NgForm): any {
    foodProdut.value.availability = true;

    if (this.foodProduct.find((product:any) => product.name.toLowerCase() === foodProdut.value.name.toLowerCase())) {
      // this.addNewProduct.pop();
      this.error = "FOOD PRODUCT ALREADY EXSITS"
      console.log("ERROR")
    }
    else{
    this.addNewProduct.pop();
    this.addNewProduct.push(foodProdut.value);
    this.foodProductService
      .addFoodproductsByMenuid(this.addNewProduct, this._menuId)
      .subscribe((response) => {
        this.router.navigate(['/menu', this._userId]);
        this.menuService.getMenuByUserId(this._userId).subscribe((response) => {
          this.foodProducts = response;
          this.foodProduct = this.foodProducts.data.foodProducts;
          this._menuId = this.foodProducts.data.id;
          this.getTypes();
          console.log(this._menuId);
        });
      });
  }
  }
  // Delete Product by id

  deleteFoodProduct(id: any) {
    console.log(id);
    this.foodProductService.deleteFoodproductById(id).subscribe((response) => {
      console.log(response);
      this.router.navigate(['/menu', this._userId]);
      this.menuService.getMenuByUserId(this._userId).subscribe((response)=>{
        this.foodProducts = response;
        this.foodProduct = this.foodProducts.data.foodProducts;
        this._menuId = this.foodProducts.data.id;
        console.log(this._menuId)
      })
    });
  }

 getTypes(){
   this.foodProductService.getDistinctTypes().subscribe((response)=>{
    this.types = response
    this.types = this.types.data
  })
}

changeStatus(id:any){
  console.log(id)
  this.foodProduct.filter((product:any)=>{
    if(product.id === id){
      product.availability = !product.availability
      console.log(product)
        this.foodProductService.updateFoodProduct(product,this._menuId,id).subscribe((response)=>{
          this.router.navigate(["/menu",localStorage.getItem("id")])
          this.menuService.getMenuByUserId(this._userId).subscribe((response)=>{
            this.foodProducts = response;
            this.foodProduct = this.foodProducts.data.foodProducts;
            this._menuId = this.foodProducts.data.id;
        });
        })
    }
  })
}

changeStaffStatus(id:any){
  this.staffs.filter((user:any)=>{
    if(user.id === id){
      console.log(user)
      user.active = !user.active;
      this.userService.updateStaff(user,id).subscribe((response)=>{
        console.log(response)
          this.router.navigate(["/menu",localStorage.getItem("id")])

      })
    }
  })
}

getFoodOrders(){
  this.staffService.getAllFoodOrders().subscribe((response)=>{
    this.foodOrders = response;
    this.foodOrders = this.foodOrders.data;
    console.log(this.foodOrders)
  })
}


}
