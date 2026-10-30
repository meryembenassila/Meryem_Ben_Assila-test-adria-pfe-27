import {ChangeDetectorRef, Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Transaction} from '../services/transaction';
import {DatePipe, DecimalPipe} from '@angular/common';

@Component({
  selector: 'app-trnsaction',
  imports: [
    DatePipe,
    DecimalPipe
  ],
  templateUrl: './trnsaction.html',
  styleUrl: './trnsaction.css',
})
export class Trnsaction {

  transactions: any[] = [];
  errorMessage: string = '';

  constructor(private transactionService:Transaction, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.transactionService.getTransactions().subscribe({

      next: (data) => {
        console.log('Données reçues :', data);


        this.transactions = data;
        this.errorMessage = '';
        this.cdr.detectChanges();
      },

      error: (err) => {
        console.error('Erreur :', err);
        this.errorMessage = 'Erreur lors de la récupération des transactions.';
        this.cdr.detectChanges();
      }
    });
  }
}
