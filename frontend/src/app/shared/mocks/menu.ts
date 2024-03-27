import { ActionName } from "../models/menu"

export const menuElements = [
    {
      icon: 'fullscreen',
      name: 'Tryb pełnoekranowy',
      action: ActionName['fullscreen'],
      id: 1
    },
    {
      icon: 'add',
      name: 'Dodaj urządzenie',
      action: ActionName['addDevice'],
      id: 2
    },
    {
      icon: 'dashboard',
      name: 'Panel główny',
      action: ActionName['dashboard'],
      id: 3
    },
    {
      icon: 'home_pin',
      name: 'Zarządaj otoczeniem',
      action: ActionName['manageLocalizations'],
      id: 4
    },
    {
      icon: 'settings',
      name: 'Ustawienia aplikacji',
      action: ActionName['settings'],
      id: 5
    },
    {
      icon: 'power_settings_new',
      name: 'Wyjdź z lokalizacji',
      action: ActionName['logout'],
      id: 6
    },
  ]

  export const menuLocalizations = [
    {
      name: 'Salon',
      icon: 'chair',
      id: 11
    },
    {
      name: 'Kuchnia',
      icon: 'oven_gen',
      id: 12,
    },
  ]