import { ActionName, DisplayType } from "../models/menu"

export const menuElements = [
    {
      icon: 'fullscreen',
      name: 'Fullscreen',
      action: ActionName.fullscreen,
      display: DisplayType.both,
      id: 1
    },
    {
      icon: 'chevron_left',
      name: 'Sidebar',
      action: ActionName.showHideNav,
      display: DisplayType.desktop,
      id: 2
    },
    {
      icon: 'add',
      name: 'Add device',
      action: ActionName.addDevice,
      display: DisplayType.mobile,
      id: 3
    },
    {
      icon: 'dashboard',
      name: 'Dashboard',
      action: ActionName.dashboard,
      display: DisplayType.both,
      id: 4
    },
    // {
    //   icon: 'home_pin',
    //   name: 'Zarządaj otoczeniem',
    //   action: ActionName.manageLocalizations,
    //   display: DisplayType.both,
    //   id: 5
    // },
    // {
    //   icon: 'settings',
    //   name: 'Ustawienia aplikacji',
    //   action: ActionName.settings,
    //   display: DisplayType.both,
    //   id: 6
    // },
    {
      icon: 'logout',
      name: 'Exit',
      action: ActionName.logout,
      display: DisplayType.both,
      id: 5
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