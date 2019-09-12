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
import { EditHealthCardComponent } from '../core/edit-health-card/edit-health-card.component';
import { MakeReportComponent } from '../core/make-report/make-report.component';
import { MakeReferralForSpecExamComponent } from '../core/make-referral-for-spec-exam/make-referral-for-spec-exam.component';
import { MakeReferralForLabComponent } from '../core/make-referral-for-lab/make-referral-for-lab.component';
import { MakeDoctorReceiptComponent } from '../core/make-doctor-receipt/make-doctor-receipt.component';
import { ReportCreatedComponent } from '../core/report-created/report-created.component';


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
    path: 'patient/:idOfPatientNum',
    component: PatientPageComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['DOCTOR']
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
  {
    path: 'edit-health-card/:numberOfHealthCard',
    component: EditHealthCardComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['DOCTOR']
    }
  },
  {
    path: 'make-report/:idOfPatientNum',
    component: MakeReportComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['DOCTOR']
    }
  },
  {
    path: 'report-created/:diagnosis/:idOfReportNum/:idOfPatientNum',
    component: ReportCreatedComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['DOCTOR']
    }
  },
  {
    path: 'make-referral-for-spec-exam/:idOfPatientNum',
    component: MakeReferralForSpecExamComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['DOCTOR']
    }
  },
  {
    path: 'make-referral-for-lab/:idOfPatientNum',
    component: MakeReferralForLabComponent,
    canActivate: [CanActivateUserGuard],
    data: {
      expectedRoles: ['DOCTOR']
    }
  },
  {
    path: 'make-doctor-receipt/:idOfPatientNum',
    component: MakeDoctorReceiptComponent,
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
