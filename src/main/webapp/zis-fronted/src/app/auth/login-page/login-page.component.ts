import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/core/services/authentication/authentication.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  public user;

  constructor(private authenticationService: AuthenticationService, private router: Router,
              private toastr: ToastrService) {
    this.user = {};
  }

  ngOnInit() {
    if (this.authenticationService.isLoggedIn()) {
        const currentUser: any = this.authenticationService.getCurrentUser();
        this.goToPageOfLoggedUser(currentUser);
    }
  }

  login(): void {
    this.authenticationService.login(this.user.username, this.user.password)
    .subscribe(
      (loggedIn: boolean) => {
          console.log(loggedIn);
          if (loggedIn) {
            const currentUser: any = this.authenticationService.getCurrentUser();
            this.toastr.success('Successfully logged in as ' + currentUser.username);
            this.goToPageOfLoggedUser(currentUser);
          }
          else {
            this.toastr.error('Unsuccessfully login :(');
          }
      },
      (err: Error) => {
        /*if (err.toString() === 'Ilegal login') {
          this.wrongUsernameOrPass = true;
          console.log(err);
        } else {
          Observable.throw(err);
        }
        this.toastr.error(JSON.stringify(err));
      }*/
        this.toastr.error('Unsuccessfully login :(');
      }
    );
  }

  goToPageOfLoggedUser(currentUser: any) {
      const roles: any[] = currentUser.roles;
      const role = roles[0];

      if (role === 'PATIENT') {
        this.router.navigate(['/patient']);
      }
      else if (role === 'NURSE') {
        this.router.navigate(['/nurse']);
      }
      else if (role === 'DOCTOR') {
        this.router.navigate(['/doctor']);
      }
      else {
        this.toastr.error('Unknown user type!');
      }
  }

}
