import { NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'at-acces-denied',
  templateUrl: './acces-denied.component.html',
  styleUrl: '../not-found/not-found.component.scss',
  standalone: true,
  imports: [NgOptimizedImage]
})
export class AccesDeniedComponent {}
