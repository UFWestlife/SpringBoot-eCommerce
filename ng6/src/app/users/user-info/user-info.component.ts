import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../shared/services/auth.service';
import {UserDetail} from '../../shared/models/user-detail';
import {User} from '../../shared/models/user';
import {UserDetailService} from '../../shared/services/user-detail.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.scss']
})
export class UserInfoComponent implements OnInit {

  userDetail: UserDetail = new UserDetail();

  constructor(
    private authService: AuthService,
    private userDetailService: UserDetailService
  ) { }

  ngOnInit() {
    this.authService.userSubject
      .subscribe((user: User) => {
        if (user && user.userDetail) {
          this.userDetail = user.userDetail;
        }
      });
  }

  onSubmit() {
    if (this.userDetail.id) {
      this.userDetailService.updateUserDetail(this.userDetail)
        .subscribe(res => {
          // update success
          this.authService.checkLogin(); // update user detail in userSubject(workaround. TODO: create user detail subject).
        });
    } else {
      this.userDetailService.addUserDetail(this.userDetail)
        .subscribe((res: {success: boolean, userDetail: UserDetail}) => {
          if (res.success) {
            this.userDetail = res.userDetail; // add success, update user detail with id.
            this.authService.checkLogin();
          }
        });
    }
  }

}
