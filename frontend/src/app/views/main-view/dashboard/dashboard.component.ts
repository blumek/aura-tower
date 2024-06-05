import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription, catchError, tap, throwError } from 'rxjs';
import { Metric, WebSocketMetric } from '../models/devices';
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
  metrics!: Metric[];
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
      tap((res: Metric[]) => {
        // this.metrics = res;
        this.metrics = [
          {
            id: '1',
            name: 'MR-2236 Vacume',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Vacuum robot',
              },
              data: {
                status: 'off',
                "batery level": '78',
                positionX: '23',
                positionZ: '61'
              },
            },
          },
          {
            id: '1',
            name: 'AC-7821',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Air Condition',
              },
              data: {
                status: 'on',
                temperature: '21',
                mode: 'Cool mode',
              },
            },
          },
          {
            id: '1',
            name: 'TR-3677',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Smart termometr',
              },
              data: {
                status: 'on',
                temperature: '21',
              },
            },
          },
          {
            id: '1',
            name: 'Smart light Bulb',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Light bulb',
              },
              data: {
                status: 'on',
                color: '#ffaa2d',
              },
            },
          },
          {
            id: '1',
            name: 'LO-9721',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Smart lock',
              },
              data: {
                "door status": 'closed',
                "lock": true,
              },
            },
          },
          {
            id: '1',
            name: 'LO-9721',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Smart lock',
              },
              data: {
                "door status": 'closed',
                "lock": true,
              },
            },
          },
          {
            id: '1',
            name: 'TV-OLED-K962',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Smart TV',
              },
              data: {
                status: 'on',
                chanel: '261',
                volume: '50',
                "is mute": false,
              },
            },
          },
          {
            id: '1',
            name: 'AT-21XC',
            device: {
              id: '1',
              type: {
                id: '1',
                name: 'Smart Audio Tower',
              },
              data: {
                status: 'on',
                volume: '65',
                "is mute": false,
                "is playing": true,
                "is paused": false,
                "is stopped": false,
              },
            },
          },
        ]
        // this.openWebSocketConnection();
      }),
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
      .watch(
        environment.metrics.ws.replace(
          '$placeIdentifier',
          this.headquarterId.toString()
        )
      )
      .subscribe((message: any) => {
        const webSocketData = JSON.parse(message.body)
        this.mapMetricsDataFromSocket(webSocketData)
      });
  }

  mapMetricsDataFromSocket(webSocketData: WebSocketMetric): void {
    const selectedMetric = this.metrics.find((metric: Metric) => metric.id === webSocketData.id)

    if (selectedMetric) {
      selectedMetric.device.data = webSocketData.deviceData
    }
  }

  openAddDeviceDialog(): void {
    this.deviceService.openAddDeviceDialog();
  }

  openAddDeviceDialogFnc = this.openAddDeviceDialog.bind(this);

  ngOnDestroy(): void {
    this.topicSubscription.unsubscribe();
  }
}
