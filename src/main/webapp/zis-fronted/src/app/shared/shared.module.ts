import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotFoundPageComponent } from './not-found-page/not-found-page.component';
import { AppRoutingModule } from '../routes/app-routing.module';
import { RouterModule } from '@angular/router';
import { SafeHtmlPipe } from './pipe/safe-html.pipe';

@NgModule({
  declarations: [NotFoundPageComponent, SafeHtmlPipe],
  imports: [
    CommonModule,
    RouterModule // treba nam zbog RouterModule-a
  ],
  exports: [SafeHtmlPipe]
})
export class SharedModule { }
