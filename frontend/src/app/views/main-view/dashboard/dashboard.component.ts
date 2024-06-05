import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription, catchError, tap, throwError } from 'rxjs';
import { Metric } from '../models/devices';
import { DevicesService } from '../services/devices.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';
import { ActivatedRoute } from '@angular/router';
import { WebSocketService } from '../../../core/web-socket/web-socket.service';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'at-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
})
export class DashboardComponent implements OnInit, OnDestroy {
  loading: boolean = false;
  data$!: Observable<Metric[]>;
  topicSubscription!: Subscription;
  headquarterId: string = this.activatedRoute.snapshot.params['id'];

  constructor(
    private deviceService: DevicesService,
    private webSocketService: WebSocketService,
    private snackbarService: SnackbarService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getMetricsData();
  }

  getMetricsData(): void {
    

    this.data$ = this.deviceService.fetchMetricsData(this.headquarterId).pipe(
      tap(() => this.openWebSocketConnection()),
      catchError((err) => {
        this.snackbarService.openSnackBar(
          'Błąd pobierania danych urządzeń',
          true
        );
        return throwError(() => err);
      })
    );
  }

  openWebSocketConnection(): void {
    this.topicSubscription = this.webSocketService
      .watch(environment.metrics.ws.replace('$placeIdentifier', this.headquarterId.toString()))
      .subscribe((message: any) => {
        console.log(message.body);
      });
  }

  openAddDeviceDialog(): void {
    this.deviceService.openAddDeviceDialog();
  }

  openAddDeviceDialogFnc = this.openAddDeviceDialog.bind(this);

  ngOnDestroy(): void {
    this.topicSubscription.unsubscribe();
  }
}