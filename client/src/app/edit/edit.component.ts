import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodProductService } from '../Services/food-product.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  result: any;
  selectedProduct: any;
  id:any;
  menuId: any;
  constructor( private activatedRoute: ActivatedRoute,private foodProduct:FoodProductService,private router:Router) { }
  
  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['productid']; // 73
    this.menuId = this.activatedRoute.snapshot.params['menuid'];
    this.foodProduct.getFoodProductsByMenuId(9).subscribe((data)=>{ // list of products
      this.result = data;
      for (let item of this.result.data) {
        if (item.id == this.id) {
          this.selectedProduct = item;
          console.log(this.selectedProduct)
        }
      }
    })
  }

  updateFoodproduct(form:NgForm){
    this.foodProduct.updateFoodProduct(form.value,this.menuId,this.id).subscribe((response)=>{
      this.router.navigate(["/menu",localStorage.getItem("id")])
    })
}

}
