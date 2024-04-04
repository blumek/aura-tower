export enum ActionName {
    fullscreen = 'full-screen',
    fullscreenExit = 'full-screen-exit',
    addDevice = 'add-device',
    dashboard = 'dashboard',
    manageLocalizations = 'manage-localizations',
    settings = 'settings',
    logout = 'logout',
    showHideNav = 'show-hide-nav'
}

export interface IMenu {
    icon: string;
    name: string;
    action: ActionName;
    id: number;
    mobile?: boolean;
}