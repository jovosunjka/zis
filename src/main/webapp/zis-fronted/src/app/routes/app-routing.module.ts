import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CanActivateUserGuard } from './guard/can-activate-user.guard';
import { PatientPageComponent } from '../core/patient-page/patient-page.component';
import { NursePageComponent } from '../core/nurse-page/nurse-page.component';
import { LoginPageComponent } from '../auth/login-page/login-page.component';
import { RegisterPageComponent } from '../auth/register-page/register-page.component';
import { NotFoundPageComponent } from '../shared/not-found-page/not-found-page.component';
import { HomePageComponent } from '../core/home-page/home-page.component';
import { DoctorPageComponent } from '../core/doctor-page/doctor-page.component';


const appRoutes: Routes = [
  { path: 'home-page', component: HomePageComponent },
  { path: 'login', component: LoginPageComponent},
  { path: 'register', component: RegisterPageComponent},
  {
    path: 'patient',
    component: PatientPageComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['PATIENT']
    }
  },
  {
    path: 'nurse',
    component: NursePageComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['NURSE']
    }
  },
  {
    path: 'doctor',
    component: DoctorPageComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['DOCTOR']
    }
  },
  { path: '', // localhost:4200 redirect to localhost:4200/home-page
    redirectTo: '/home-page',
    pathMatch: 'full'
  },
  { path: '**', component: NotFoundPageComponent } // za sve ostale path-ove izbaci page not found
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CanActivateUserGuard],
  exports: [RouterModule]
})
export class AppRoutingModule { }
