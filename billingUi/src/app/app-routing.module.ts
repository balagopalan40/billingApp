import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { PurchaseOrderComponent } from './purchase-order/purchase-order.component';

const routes: Routes = [
	  
    {
        path: 'login',
        component: LoginComponent
    },    
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'purchase-order',
        component: PurchaseOrderComponent
    }

    

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
