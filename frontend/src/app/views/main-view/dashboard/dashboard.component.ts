import { Component, OnInit } from '@angular/core';
import { mockDevices } from '../../../shared/mocks/devices';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { IDevice } from '../../../shared/models/devices';
import { DevicesService } from '../../../shared/services/devices.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {
  loading: boolean = false;
  devices = [];
  homeName = 'Domek Jordana'
  data$!: Observable<IDevice[]>
  deviceData!: IDevice[]

  constructor(
    private deviceService: DevicesService,
    private snackbarService: SnackbarService
  ){}

  ngOnInit(): void {
    this.getDevicesData()
  }

  getDevicesData(): void {
    this.data$ = this.deviceService.fetchDevicesData().pipe(
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
