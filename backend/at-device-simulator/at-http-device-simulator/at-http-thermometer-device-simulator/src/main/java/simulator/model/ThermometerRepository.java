package simulator.model;

public interface ThermometerRepository {
    Thermometer findThermometerWithIdentifier(ThermometerIdentifier identifier);
    void save(Thermometer thermometer);
}
