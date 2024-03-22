package com.tower.aura.rest.web.adapter.controller.metric;

import java.util.Map;

public record Metrics(String id, String name, DeviceType deviceType, Map<String, Object> deviceData) {
}
