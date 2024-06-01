package simulator.model;

public class Thermometer {
    private final ThermometerIdentifier identifier;
    private TemperatureCelsius temperatureCelsius;

    private Thermometer(ThermometerIdentifier identifier, TemperatureCelsius temperatureCelsius) {
        this.identifier = identifier;
        this.temperatureCelsius = temperatureCelsius;
    }

    public void updateTemperature(TemperatureCelsius temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public static Thermometer create(ThermometerIdentifier identifier, TemperatureCelsius temperatureCelsius) {
        return new Thermometer(identifier, temperatureCelsius);
    }

    public ThermometerSnapshot toThermometerSnapshot() {
        return new ThermometerSnapshot(identifier, temperatureCelsius);
    }
}
