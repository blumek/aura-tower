package simulator.model;

import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ThermometerIdentifier(String value) {
    public ThermometerIdentifier {
        if (isBlank(value)) {
            throw new IllegalArgumentException("Thermometer identifier cannot be blank");
        }
    }

    public static ThermometerIdentifier generate() {
        return new ThermometerIdentifier(UUID.randomUUID().toString());
    }
}
