import { Component, OnInit } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Metric } from '../models/devices';
import { DevicesService } from '../services/devices.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';

@Component({
  selector: 'at-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {
  loading: boolean = false;
  data$!: Observable<Metric[]>

  constructor(
    private deviceService: DevicesService,
    private snackbarService: SnackbarService
  ){}

  ngOnInit(): void {
    this.getMetricsData()
  }

  getMetricsData(): void {
    this.data$ = this.deviceService.fetchMetricsData().pipe(
      catchError(err => {
        this.snackbarService.openSnackBar('Błąd pobierania danych urządzeń', true)
        return throwError(() => err)
      })
    )
  }

  openAddDeviceDialog(): void {
    this.deviceService.openAddDeviceDialog();
  }

  openAddDeviceDialogFnc = this.openAddDeviceDialog.bind(this)

}
