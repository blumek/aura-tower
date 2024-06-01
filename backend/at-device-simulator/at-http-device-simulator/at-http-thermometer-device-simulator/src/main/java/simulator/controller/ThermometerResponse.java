package simulator.controller;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record ThermometerResponse(String identifier,
                                  double temperature) {
    public ThermometerResponse {
        if (isBlank(identifier)) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
    }
}
