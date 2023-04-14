import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FoodProductService } from '../Services/food-product.service';
import { MenuService } from '../Services/menu.service';

@Component({
  selector: 'app-food-products',
  templateUrl: './food-products.component.html',
  styleUrls: ['./food-products.component.css']
})
export class FoodProductsComponent implements OnInit {
  _userId = localStorage.getItem("id");
  foodProducts: any;
  foodProduct: any;
  _menuId: any;

  constructor(private menuService : MenuService,private foodProductService:FoodProductService,private router : Router) { }

  ngOnInit(): void {
    this.menuService.getMenuByUserId(this._userId).subscribe((response) => {
      this.foodProducts = response;
      this.foodProducts = this.foodProducts.data.foodProducts;
      this._menuId = this.foodProducts.data.id;
    });
  }

  
  deleteFoodProduct(id: any) {
    this.foodProductService.deleteFoodproductById(id).subscribe((response) => {
      console.log(response);
      this.router.navigate(['/menu', this._userId]);
      this.menuService.getMenuByUserId(this._userId).subscribe((response)=>{
        this.foodProducts = response;
        this.foodProduct = this.foodProducts.data.foodProducts;
        this._menuId = this.foodProducts.data.id;
      })
    });
  }

}
