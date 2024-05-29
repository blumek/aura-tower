export interface CommandCenter {
    name: string;
    icon: string;
    id?: string;
    configModeType?: ConfigModeTypes
}

export interface CommandCenterEdit {
    addingMode: boolean,
    centerName: string,
    centerIcon: string
}

export enum ConfigModeTypes {
    config = 'config',
    add = 'add',
    normal = 'normal'
}