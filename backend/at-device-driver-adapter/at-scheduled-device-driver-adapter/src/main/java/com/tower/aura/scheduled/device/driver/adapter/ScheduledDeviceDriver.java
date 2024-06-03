package com.tower.aura.scheduled.device.driver.adapter;

import com.tower.aura.spi.device.DeviceDriverProcessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledDeviceDriver {
    private final List<DeviceDriverProcessor> scheduledDeviceDriverProcessors;

    public ScheduledDeviceDriver(List<DeviceDriverProcessor> scheduledDeviceDriverProcessors) {
        this.scheduledDeviceDriverProcessors = scheduledDeviceDriverProcessors;
    }

    @Scheduled(fixedDelay = 1000)
    public void runScheduledProcessors() {
        scheduledDeviceDriverProcessors.forEach(DeviceDriverProcessor::process);
    }
}
