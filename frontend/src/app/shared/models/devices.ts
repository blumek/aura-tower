export interface IDevice {
    id: string;
    name: string;
    deviceType: IDeviceType;
    deviceData: any
}

interface IDeviceType {
    id: string;
    name: string;
}