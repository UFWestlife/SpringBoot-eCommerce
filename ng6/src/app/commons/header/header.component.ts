import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../shared/services/auth.service';
import {Router} from '@angular/router';
import {ShoppingCartService} from '../../shared/services/shopping-cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  show = false;

  constructor(
    private authService: AuthService,
    private router: Router,
    private shoppingCartService: ShoppingCartService
  ) { }

  ngOnInit() {
    // this.authService.userSubject.subscribe((res) => {
    //   console.log(res);
    // });
  }

  logout() {
    this.authService.logout()
      .subscribe((res: {success: true}) => {
        if (res.success) {
          this.router.navigate(['/home']);
          this.authService.userSubject.next(null);
        }
      });
  }

  toggleCollapse() {
    this.show = !this.show;
  }

}
