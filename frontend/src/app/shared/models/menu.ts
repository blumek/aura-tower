export enum ActionName {
    fullscreen = 'full-screen',
    fullscreenExit = 'full-screen-exit',
    addDevice = 'add-device',
    dashboard = 'dashboard',
    manageLocalizations = 'manage-localizations',
    settings = 'settings',
    logout = 'logout',
}

export interface IMenu {
    icon: string;
    name: string;
    action: ActionName;
    id: number;
}