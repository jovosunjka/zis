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
import { OrderReviewComponent } from './order-review/order-review.component';
import { HealthCardComponent } from './health-card/health-card.component';
import { BasicInformationsComponent } from './basic-informations/basic-informations.component';
import { ReportsComponent } from './reports/reports.component';
import { ReferralsComponent } from './referrals/referrals.component';
import { ReferralsForSpecExaminationComponent } from './referrals-for-spec-examination/referrals-for-spec-examination.component';
import { ReferralsForLabComponent } from './referrals-for-lab/referrals-for-lab.component';
import { DoctorRecipesComponent } from './doctor-recipes/doctor-recipes.component';
import { PatientsComponent } from './patients/patients.component';
import { EditHealthCardComponent } from './edit-health-card/edit-health-card.component';
import { MakeReportComponent } from './make-report/make-report.component';
import { MakeReferralForSpecExamComponent } from './make-referral-for-spec-exam/make-referral-for-spec-exam.component';
import { MakeReferralForLabComponent } from './make-referral-for-lab/make-referral-for-lab.component';
import { MakeDoctorReceiptComponent } from './make-doctor-receipt/make-doctor-receipt.component';
import { OrderedReviewsComponent } from './ordered-reviews/ordered-reviews.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { ReportCreatedComponent } from './report-created/report-created.component';

@NgModule({
  declarations: [
    PatientPageComponent,
    HomePageComponent,
    NursePageComponent,
    DoctorPageComponent,
    ChooseDoctorComponent,
    OrderReviewComponent,
    HealthCardComponent,
    BasicInformationsComponent,
    ReportsComponent,
    ReferralsComponent,
    ReferralsForSpecExaminationComponent,
    ReferralsForLabComponent,
    DoctorRecipesComponent,
    PatientsComponent,
    EditHealthCardComponent,
    MakeReportComponent,
    MakeReferralForSpecExamComponent,
    MakeReferralForLabComponent,
    MakeDoctorReceiptComponent,
    OrderedReviewsComponent,
    NotificationsComponent,
    ReportCreatedComponent
  ],
  imports: [
    CommonModule,
    ToastrModule.forRoot({preventDuplicates: true}), // ToastrModule added,
    AuthModule,
    HttpClientModule,
    SharedModule,
    FormsModule,
    CKEditorModule
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
