export interface CommandCenter {
    name: string;
    icon: string;
    id?: string;
    configModeType?: ConfigModeTypes
}

export enum ConfigModeTypes {
    config = 'config',
    add = 'add',
    normal = 'normal'
}