import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BranchComponent } from './branch/branch.component';
import { StaffComponent } from './staff/staff.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { TotalPricePipe } from './Pipes/total-price.pipe';
import { FilterByTypePipe } from './Pipes/filter-by-type.pipe';
import { NavbarComponent } from './navbar/navbar.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { TypesPipe } from './Pipes/types.pipe';
import { FilterBYNamePipe } from './Pipes/filter-byname.pipe';
import { AlertComponent } from './alert/alert.component';
import { InvoicegeneratorComponent } from './invoicegenerator/invoicegenerator.component';
import { AuthGuard } from './Guard/auth.guard';
import { AvailabilityPipe } from './Pipes/availability.pipe';
import { EditComponent } from './edit/edit.component';
import { FoodProductsComponent } from './food-products/food-products.component';
import { StatusPipe } from './Pipes/status.pipe';


@NgModule({
  declarations: [
    AppComponent,
    BranchComponent,
    StaffComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    FoodOrderComponent,
    AlertComponent,
    InvoicegeneratorComponent,
    TotalPricePipe,
    FilterByTypePipe,
    TypesPipe,
    FilterBYNamePipe,
    AvailabilityPipe,
    EditComponent,
    FoodProductsComponent,
    StatusPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [TotalPricePipe,TypesPipe,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
