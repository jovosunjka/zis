import { Component, OnInit, Input } from '@angular/core';
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

  @Input()
  idOfPatientNum: string;


  constructor(private doctorRecipesService: GenericService, private toastr: ToastrService) {
    this.relativeUrlAllDoctorRecipes = '/patient/all-recipes';
    this.xHtmlContetntForDoctorRecipes = 'Loading recipes...';
   }

  ngOnInit() {
    this.getAllRecipes();
  }

  getAllRecipes () {
    if (this.idOfPatientNum) {
      this.relativeUrlAllDoctorRecipes += '/' + this.idOfPatientNum;
    }
    this.doctorRecipesService.get<string>(this.relativeUrlAllDoctorRecipes).subscribe(
      (receivedXml: string) => {
          if (receivedXml) {
              // this.xHtmlContetntForPatients = receivedXml.replace(/"/g, ''); // izbacujemo navodnike
              this.xHtmlContetntForDoctorRecipes = this.doctorRecipesService.replaceAllBackSlash(receivedXml.substring(1,
                receivedXml.length - 1));
              // izbacujemo navodnike sa pocetka i kraja, i back-slash-ove
              this.toastr.success('Recipes are successfully loaded!');
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
