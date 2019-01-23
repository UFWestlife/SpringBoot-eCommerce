import {async, ComponentFixture, TestBed, tick} from '@angular/core/testing';

import { ProductsComponent } from './products.component';
import {ProductsService} from '../shared/services/products.service';
import {Product} from '../shared/models/product';
import {of} from 'rxjs/index';
import {CustomStyleModule} from '../shared/modules/custom-style/custom-style.module';
import {FormsModule} from '@angular/forms';
import {ProductsPipePipe} from '../shared/pipes/products-pipe.pipe';
import {RouterTestingModule} from '@angular/router/testing';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

fdescribe('ProductsComponent', () => {
  let component: ProductsComponent;
  let fixture: ComponentFixture<ProductsComponent>;
  let productsList;

  const products: Product[] = [
    {id: 1, name: 'test1', brand: 'apple', price: 100, stock: 100, image: ''},
    {id: 2, name: 'test2', brand: 'google', price: 200, stock: 100, image: ''},
    {id: 3, name: 'test3', brand: 'amazon', price: 300, stock: 100, image: ''}
  ];

  let productsService = jasmine.createSpyObj('ProductsService', ['getProducts']);
  productsService.getProducts.and.returnValue( of(products) );

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        BrowserAnimationsModule,
        CustomStyleModule,
        FormsModule,
        RouterTestingModule
      ],
      declarations: [ ProductsComponent, ProductsPipePipe ],
      providers: [
        {
          provide: ProductsService,
          useValue: productsService
        }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    productsList = fixture.nativeElement.querySelector('.products-list-container');
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display products', async(() => {
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      expect(productsList.children.length).toBe(3);
    });

  }));
});
