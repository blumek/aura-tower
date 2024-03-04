import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';

import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';


const sharedComponents = [
  HeaderComponent
]


@NgModule({
  declarations: [
    sharedComponents
  ],
  exports: [
    sharedComponents
  ],
  imports: [
    CommonModule,
    MatIconModule,
    MatMenuModule
  ]
})
export class SharedModule { }
