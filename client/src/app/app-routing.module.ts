import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BranchComponent } from './branch/branch.component';
import { EditComponent } from './edit/edit.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { AuthGuard } from './Guard/auth.guard';
import { RoleGuardGuard } from './Guard/role-guard.guard';
import { InvoicegeneratorComponent } from './invoicegenerator/invoicegenerator.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { StaffComponent } from './staff/staff.component';

const routes: Routes = [
  { path: '', redirectTo: 'register', pathMatch: 'full' },

  {
    path: 'login',
    component: LoginComponent,
  },

  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'menu/:id',
    component: BranchComponent,
    canActivate: [AuthGuard, RoleGuardGuard],
    data:{
      expectedRoles:['ADMIN']
    }
  },
  {
    path:"staff/:id",
    component:StaffComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "invoice/:id",
    component: InvoicegeneratorComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "foodorders/:staffid",
    component: FoodOrderComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "edit/:menuid/:productid",
    component: EditComponent,
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
