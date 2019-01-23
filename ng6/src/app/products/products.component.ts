import { Component, OnInit } from '@angular/core';
import {ProductsService} from '../shared/services/products.service';
import {Product} from '../shared/models/product';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  products: Product[];
  brands = [];
  filteredBrand = '';
  min: number;
  max: number;

  constructor(
    private ps: ProductsService
  ) { }

  ngOnInit() {
    this.ps.getProducts().subscribe((res) => {
      this.products = res;
      this.brands = this.products.map(p => p.brand).filter((p, index, self) => self.indexOf(p) === index);
    });
  }

  clearFilters() {
    this.filteredBrand = ''
    this.min = null;
    this.max = null;
  }

}
