import { Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StaffService } from '../Services/staff.service';



@Component({
  selector: 'app-invoicegenerator',
  templateUrl: './invoicegenerator.component.html',
  styleUrls: ['./invoicegenerator.component.css']
})
export class InvoicegeneratorComponent implements OnInit {
  order: any;
  items: any;
 
  constructor(private route: ActivatedRoute,private foodOrder:StaffService) { }

  id = this.route.snapshot.paramMap.get("id")

  ngOnInit(): void {
    this.foodOrder.getFoodOrderById(this.id).subscribe((response)=>{
      console.log(response)
      this.order = response;
      this.order = this.order.data;
      this.items = this.order.item;
      console.log(this.items)
    })
  }

element: ElementRef | undefined;

get(){
window.print();
}

}
