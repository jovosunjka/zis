import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationService } from './services/authentication/authentication.service';
import { ToastrModule } from 'ngx-toastr';
import { GenericService } from './services/generic/generic.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { TokenInterceptorService } from './services/token-interceptor/token-interceptor.service';
import { JwtUtilsService } from './services/jwt-utils/jwt-utils.service';
import { HomePageComponent } from './home-page/home-page.component';
import { PatientPageComponent } from './patient-page/patient-page.component';
import { NursePageComponent } from './nurse-page/nurse-page.component';
import { DoctorPageComponent } from './doctor-page/doctor-page.component';
import { AuthModule } from '../auth/auth.module';
import { ChooseDoctorComponent } from './choose-doctor/choose-doctor.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [PatientPageComponent, HomePageComponent, NursePageComponent, DoctorPageComponent, ChooseDoctorComponent],
  imports: [
    CommonModule,
    ToastrModule.forRoot({preventDuplicates: true}), // ToastrModule added,
    AuthModule,
    HttpClientModule,
    SharedModule,
    FormsModule
  ],
  providers: [
    AuthenticationService,
    GenericService,
    JwtUtilsService,
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptorService, multi: true },
    { provide: 'BASE_API_URL', useValue: 'http://localhost:8081/api' },  // environment.apiUrl
  ]
})
export class CoreModule { }
