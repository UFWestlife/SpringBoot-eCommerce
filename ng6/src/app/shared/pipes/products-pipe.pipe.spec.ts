import { ProductsPipePipe } from './products-pipe.pipe';
import {Product} from '../models/product';

fdescribe('ProductsPipePipe', () => {

  const pipe = new ProductsPipePipe();
  const products: Product[] = [
    {
      id: 1,
      name: 'test1',
      brand: 'apple',
      price: 100,
      stock: 100,
      image: ''
    },
    {
      id: 2,
      name: 'test2',
      brand: 'google',
      price: 200,
      stock: 100,
      image: ''
    },
    {
      id: 1,
      name: 'test3',
      brand: 'amazon',
      price: 300,
      stock: 100,
      image: ''
    }
  ];

  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });
  it('test products pipe work for brand filter', () => {
    expect((pipe.transform(products, 'apple', undefined, undefined) as Product[]).length).toBe(1);
  });
});
