import { Component, OnInit } from '@angular/core';
import { GenericService } from '../services/generic/generic.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-doctor-recipes',
  templateUrl: './doctor-recipes.component.html',
  styleUrls: ['./doctor-recipes.component.css']
})
export class DoctorRecipesComponent implements OnInit {
  xHtmlContetntForDoctorRecipes: string; // dobijen koriscenjem xsl transformacije
  relativeUrlAllDoctorRecipes: string;

  constructor(private doctorRecipesService: GenericService, private toastr: ToastrService) {
    this.relativeUrlAllDoctorRecipes = '/patient/all-recipes';
    this.xHtmlContetntForDoctorRecipes = 'Loading recipes...';
   }

  ngOnInit() {
    this.getAllRecipes();
  }

  getAllRecipes () {
    this.doctorRecipesService.get<string>(this.relativeUrlAllDoctorRecipes).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              this.xHtmlContetntForDoctorRecipes = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.toastr.success('Recipes for lab are successfully loaded!');
          }
          else {
            this.xHtmlContetntForDoctorRecipes = 'Problem with loading of recipes!';
            this.toastr.error('Problem with loading of recipes!');
          }
      },
      (err) => {
        this.xHtmlContetntForDoctorRecipes = 'Problem with loading of recipes!';
        this.toastr.error('Problem with loading of recipes!');
      }
    );
  }
}
