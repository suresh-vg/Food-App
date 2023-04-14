import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'totalPrice'
})
export class TotalPricePipe implements PipeTransform {

  transform(items:any[]): any{
    var sum = 0;
    items.forEach(function (item : any){
      sum += (item.price * item.quantity);
    })
    // console.log(sum);
    return sum;
  }

}
