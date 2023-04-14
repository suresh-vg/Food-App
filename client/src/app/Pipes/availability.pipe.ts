import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'availability'
})
export class AvailabilityPipe implements PipeTransform {

  transform(foodProducts:any) {

    return foodProducts.filter((product:any) => product.availability === true);
    
  }

}
