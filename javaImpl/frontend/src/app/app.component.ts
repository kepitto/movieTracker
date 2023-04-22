import { Component } from '@angular/core';
import {AverageHypeFactorModel, HypeServiceService} from "./hype-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  avgHypeFactorList: AverageHypeFactorModel[] | undefined;
  constructor(private hypeService: HypeServiceService) {
  }

  ngOnInit() {
    this.loadAvgHype();
  }

  loadAvgHype() {
    this.hypeService.getHype().subscribe((models) => {
      this.avgHypeFactorList = models;
    });
  }
}
