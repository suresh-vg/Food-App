import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterBYName'
})
export class FilterBYNamePipe implements PipeTransform {

  transform(foodProducts: any[],pattern:string): any {

    
    if(pattern == ""){
      return foodProducts;
    }

    return foodProducts.filter(product => product.name.toLowerCase().includes(pattern.toLowerCase()));
  }

}
