import { NgIf } from '@angular/common';
import {
  Component,
  Input,
  OnDestroy,
  OnInit,
} from '@angular/core';
import { RoutesService } from '../../services/routes.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'at-header',
  standalone: true,
  imports: [NgIf],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent implements OnInit, OnDestroy {
  @Input() homeName: string = '';
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
