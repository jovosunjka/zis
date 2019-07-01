import { Component } from '@angular/core';
import { AuthenticationService } from './core/services/authentication/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'zis-fronted';

  constructor(private authenticationService: AuthenticationService) {}

  logout() {
    this.authenticationService.logout();
  }

  isLoggedIn() {
    return this.authenticationService.isLoggedIn();
  }
}
