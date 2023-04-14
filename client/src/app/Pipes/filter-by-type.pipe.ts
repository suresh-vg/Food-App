import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterByType'
})
export class FilterByTypePipe implements PipeTransform {

  transform(foodProducts: any[],type:string): any[] {

    if(!foodProducts || type.length < 1){
      return foodProducts;
    }

    return foodProducts.filter(product => product.type.toLowerCase() === type.toLowerCase());
  }

}

