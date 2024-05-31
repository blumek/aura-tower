export enum ActionName {
    fullscreen = 'full-screen',
    fullscreenExit = 'full-screen-exit',
    addDevice = 'add-device',
    dashboard = 'main/dashboard',
    manageLocalizations = 'manage-localizations',
    settings = 'base/settings',
    logout = 'logout',
    showHideNav = 'show-hide-nav'
}

export enum DisplayType {
    desktop = 'desktop',
    mobile = 'mobile',
    both = 'both'
}

export interface IMenu {
    icon: string;
    name: string;
    action: ActionName;
    id: number;
    display: DisplayType
}