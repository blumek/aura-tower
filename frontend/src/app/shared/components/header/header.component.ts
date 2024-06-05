import { NgClass, NgIf, NgOptimizedImage } from '@angular/common';
import {
  Component,
  Input,
  OnDestroy,
  OnInit,
} from '@angular/core';
import { RoutesService } from '../../../core/routes/routes.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'at-header',
  standalone: true,
  imports: [NgIf, NgOptimizedImage, NgClass],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent implements OnInit, OnDestroy {
  @Input() hideLogo: boolean = false;
  pageData!: {title: string, icon: string};
  sub!: Subscription;

  constructor(
    private routesService: RoutesService) {}

  ngOnInit(): void {
    this.sub = this.routesService.pageData.subscribe((value: {title: string, icon: string}) => {
      this.pageData = value;
    });

  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
