import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule }   from '@angular/forms';
import { HttpModule, Headers, Http, RequestOptions, Response } from '@angular/http';
import { CookieService } from 'ngx-cookie-service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { DashboardComponent } from './dashboard/dashboard.component';


import { CookieProviderService } from './services/cookie-provider/cookie-provider.service';
import { AuthService } from './auth/auth.service';
import { LoginComponent } from './login/login.component';
import { PurchaseOrderComponent } from './purchase-order/purchase-order.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    PurchaseOrderComponent   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
],
  providers: [
    CookieProviderService,
    CookieService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
