import { Routes } from '@angular/router';
import {Transaction} from './services/transaction';
import {Trnsaction} from './trnsaction/trnsaction';

export const routes: Routes = [
  {  path: 'transactions',
    component: Trnsaction}

];
