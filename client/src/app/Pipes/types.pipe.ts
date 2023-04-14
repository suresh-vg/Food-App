import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'types'
})
export class TypesPipe implements PipeTransform {

  transform(items: any[] | undefined): any {
    var _isVEG = false;
    var _isNONVEG = false;
    if (!items){
      return null;
    }
    items.filter((item:any)=>{
        if(item.type.toLowerCase() === "veg")
        {
        _isVEG = true}
        if(item.type.toLowerCase() === "nonveg" || item.type.toLowerCase() === "non-veg"){ 
          _isNONVEG = true}
    })
    return {"isVeg":_isVEG,"isNonVeg":_isNONVEG};
    
  }

}
