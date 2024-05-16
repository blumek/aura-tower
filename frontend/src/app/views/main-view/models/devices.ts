export interface Metric {
    id: string;
    name: string;
    device: Device
}

interface Device {
    id: string;
    type: DeviceType;
    data: any
}

interface DeviceType {
    id: string;
    name: string;
}