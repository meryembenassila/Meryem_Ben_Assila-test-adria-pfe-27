import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Transaction {
  constructor(private httpClient:HttpClient) {
  }
  private  apiUrl= "http://localhost:9999/TRANSFERT-MICROSERVICE/api/transactions";

  getTransactions():Observable<any[]>{
    return  this.httpClient.get<any[]>(this.apiUrl);
  }
}
