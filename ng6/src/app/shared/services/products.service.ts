import {Injectable} from '@angular/core';
import {Product} from '../models/product';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs/index';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${environment.API_URL}/products`);
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(`${environment.API_URL}/products/${id}`);
  }
}
