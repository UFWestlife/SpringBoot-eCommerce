import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Params} from '@angular/router';
import {switchMap} from 'rxjs/internal/operators';
import {ProductsService} from '../../shared/services/products.service';
import {Product} from '../../shared/models/product';
import {ShoppingCartService} from '../../shared/services/shopping-cart.service';
import {AuthService} from '../../shared/services/auth.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  product: Product;

  constructor(
    private router: ActivatedRoute,
    private ps: ProductsService,
    private shoppingCartService: ShoppingCartService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.router.paramMap.pipe(
      switchMap((paramMap: ParamMap) => {
        const id = +paramMap.get('id');
        return this.ps.getProduct(id);
      })
    ).subscribe((res) => {
      this.product = res;
    });
  }

  addToCart() {
    this.shoppingCartService.addToCart({
      qty: 1,
      product: this.product
    });
  }

}
