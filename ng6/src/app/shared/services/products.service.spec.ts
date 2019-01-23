import { TestBed, inject } from '@angular/core/testing';

import { ProductsService } from './products.service';
import {Product} from '../models/product';
import {defer} from 'rxjs/index';
import {HttpClient, HttpClientModule} from '@angular/common/http';

function asyncData<T>(data: T) {
  return defer(() => Promise.resolve(data));
}

fdescribe('ProductsService', () => {

  let httpClientSpy: { get: jasmine.Spy };
  let productsService: ProductsService;
  const expected_products: Product[] = [
    {id: 1, name: 'test1', brand: 'apple', price: 100, stock: 100, image: ''},
    {id: 2, name: 'test2', brand: 'google', price: 200, stock: 100, image: ''},
    {id: 3, name: 'test3', brand: 'amazon', price: 300, stock: 100, image: ''}
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule],
      providers: [ProductsService, HttpClient]
    });
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    productsService = new ProductsService(<any> httpClientSpy);
  });

  it('should be created', inject([ProductsService], (service: ProductsService) => {
    expect(service).toBeTruthy();
  }));

  it('should get products', () => {
    httpClientSpy.get.and.returnValue(asyncData(expected_products));
    productsService.getProducts()
      .subscribe(products => {
        expect(products).toEqual(expected_products);
      });
  });
});
