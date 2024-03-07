import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  mockData = [
    {
      name: 'Janusz',
      type: 'Odkurzacz',
      location: 'Salon',
      status: 'online',
      data: {
        power: '100',
        temperature: '23',
        humidity: '50',
        co2: '100',
        light: '100',
      }
    },
    {
      name: 'Xiaoomi Vacum Mi 2 PRO',
      type: 'Odkurzacz',
      location: 'Salon',
      status: 'online',
      data: {
        power: '100',
        water: '100',
        weight: '100',
        x: '100',
        y: '100',
        z: '100'
      }
    },
    {
      name: 'Seba',
      type: 'Głośnik',
      location: 'Salon',
      status: 'offline',
      data: {
        power: '100',
        temperature: '23',
        humidity: '50',
        co2: '100',
        light: '100',
        noise: '100',
        pressure: '100',
        sound: '100',
        voltage: '100',
        water: '100',
        weight: '100',
        x: '100',
        y: '100',
        z: '100'
      }
    },    {
      name: 'Philips Hue Z4S8E2S455',
      type: 'Żarówka',
      location: 'Salon',
      status: 'online',
      data: {
        light: '100',
        noise: '100',
        sound: '100',
        voltage: '100',
        weight: '100',
      }
    },
  ]
}
