import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../shared/services/auth.service';
import {Router} from '@angular/router';
import {User} from '../../shared/models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  err = false;
  fbSub;

  constructor(
    private as: AuthService,
    private router: Router
  ) { }

  ngOnInit() { }

  onSubmit(value) {
    this.as.login(value as User)
      .subscribe(res => {
        if (res.success) {
          this.router.navigate(['/products']);
        } else {
          this.err = true;
        }
      });
  }

  onRegister() {
    this.router.navigate(['/users/register']);
  }

  updateErr() {
    if (this.err) {
      this.err = false;
    }
  }

}
