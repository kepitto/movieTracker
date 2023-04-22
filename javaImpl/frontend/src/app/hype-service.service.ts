import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface AverageHypeFactorModel {
  id: number;
  hypeFactor: number[];
  averageHypeFactor: number;
}

@Injectable({
  providedIn: 'root'
})
export class HypeServiceService {

  private baseURL = 'http://localhost:8080/hype'
  constructor(private http: HttpClient) { }

  getHype(): Observable<AverageHypeFactorModel[]> {
    const url = `${this.baseURL}/getHype`;
    return this.http.get<AverageHypeFactorModel[]>(url);
  }
}
