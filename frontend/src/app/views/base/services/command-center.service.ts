import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommandCenter } from '../models/comand-center';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommandCenterService {

  constructor(
    private http: HttpClient
  ) { }

  fetchCommandCenters(): Observable<CommandCenter[]> {
    return this.http.get<CommandCenter[]>(environment.places.base)
  }
}
