export interface Device {
    id: string;
    name: string;
    deviceType: DeviceType;
    deviceData: any
}

interface DeviceType {
    id: string;
    name: string;
}