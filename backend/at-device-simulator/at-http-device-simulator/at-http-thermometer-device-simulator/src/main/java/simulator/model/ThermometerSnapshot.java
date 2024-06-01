package simulator.model;

public record ThermometerSnapshot(ThermometerIdentifier identifier, TemperatureCelsius temperatureCelsius) {
    public ThermometerSnapshot {
        if (identifier == null) {
            throw new IllegalArgumentException("Identifier cannot be null");
        }

        if (temperatureCelsius == null) {
            throw new IllegalArgumentException("Temperature cannot be null");
        }
    }
}
