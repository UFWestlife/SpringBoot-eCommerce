import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {BehaviorSubject, Observable, Subject, throwError} from 'rxjs/index';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {User} from '../models/user';
import {catchError, map} from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  AUTH_API_URL = `${environment.API_URL}`;

  userSubject: Subject<User> = new BehaviorSubject<User>(null);

  constructor(
    private http: HttpClient
  ) {
    this.checkLogin();
  }

  checkLogin() {
    this.http.get(`${this.AUTH_API_URL}/checklogin`, {withCredentials: true})
      .subscribe((res: {success: boolean, user: User}) => {
        if (res.success) {
          this.userSubject.next(res.user);
        }
      });
  }

  login(user: User): Observable<{success: boolean, user: User}> {
    const httpParams: HttpParams = new HttpParams()
      .append('username', user.username)
      .append('password', user.password);
    return this.http.post<{success: boolean, user: User}>(`${this.AUTH_API_URL}/login`, httpParams, {withCredentials: true})
      .pipe(
        map((res: {success: boolean, user: User}) => {
          this.userSubject.next(res.user);
          return res;
        })
      );
  }

  register(user: User): Observable<{success: boolean}> {
    return this.http.post<{success: boolean, user: User}>(`${this.AUTH_API_URL}/users`, user);
  }

  logout(): Observable<{success: boolean}> {
    return this.http.post<{success: boolean}>(`${this.AUTH_API_URL}/logout`, null, {withCredentials: true});
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(`${error.error}`);
  }
}
