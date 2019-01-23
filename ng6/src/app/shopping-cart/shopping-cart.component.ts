import { Component, OnInit } from '@angular/core';
import {ShoppingCartService} from '../shared/services/shopping-cart.service';
import {Item} from '../shared/models/item';
import {Product} from '../shared/models/product';
import {OrdersService} from '../shared/services/orders.service';
import {Order} from '../shared/models/order';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {

  items: Item[];

  qtyArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

  constructor(
    private shoppingCartService: ShoppingCartService,
    private ordersService: OrdersService
  ) { }

  ngOnInit() {
    this.items = this.shoppingCartService.items;
  }

  setCart(qty: number, product: Product) {
    this.shoppingCartService.setCart({
      qty,
      product
    });
  }

  checkout() {
    if (!this.items.length) return; // TODO: better UX.
    const order: Order = {
      purchase_date: JSON.stringify(new Date()).substring(1, 11),
      purchases: this.items
    };
    this.ordersService.addOrder(order)
      .subscribe(res => {
        this.items = [];
        this.shoppingCartService.clearCart();
      });
  }

  removeFromCart(item) {
    this.shoppingCartService.removeFromCart(item);
  }

}
