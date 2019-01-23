import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { CustomStyleModule } from './shared/modules/custom-style/custom-style.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { HeaderComponent } from './commons/header/header.component';
import { FooterComponent } from './commons/footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './users/login/login.component';
import { RegisterComponent } from './users/register/register.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailComponent } from './products/product-detail/product-detail.component';
import { ProductOverviewComponent } from './products/product-overview/product-overview.component';
import { UserInfoComponent } from './users/user-info/user-info.component';
import { OrdersComponent } from './orders/orders.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { ProductsPipePipe } from './shared/pipes/products-pipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ProductsComponent,
    ProductDetailComponent,
    ProductOverviewComponent,
    UserInfoComponent,
    OrdersComponent,
    ShoppingCartComponent,
    ProductsPipePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomStyleModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
