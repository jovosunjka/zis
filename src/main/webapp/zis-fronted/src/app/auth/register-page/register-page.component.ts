import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GenericService } from 'src/app/core/services/generic/generic.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {
  public passengerDTO;
  private relativeUrl;

  constructor(private registerService: GenericService, private router: Router) {
    this.passengerDTO = {};
    this.relativeUrl = '/users/register';
   }

  ngOnInit() {
  }

  register() {
    this.registerService.save(this.relativeUrl, JSON.stringify({username: this.passengerDTO.username,
      password1: this.passengerDTO.password1, password2: this.passengerDTO.password2, firstName: this.passengerDTO.firstName,
      lastName: this.passengerDTO.lastName, email: this.passengerDTO.email,
       address: this.passengerDTO.address})).subscribe(
        (res: any) => {
          if (res) {
            this.router.navigate(['/login']);
          }
        }
      );
  }

}
