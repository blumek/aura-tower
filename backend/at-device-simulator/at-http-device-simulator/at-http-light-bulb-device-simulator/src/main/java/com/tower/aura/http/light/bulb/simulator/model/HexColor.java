package com.tower.aura.http.light.bulb.simulator.model;

import java.util.regex.Pattern;

public record HexColor(String value) {
    private static final Pattern pattern = Pattern.compile("^#[a-fA-F0-9]{4}$");

    public HexColor {
        if (!isValidHexCode(value)) {
            throw new IllegalArgumentException("Invalid hex code");
        }
    }

    public static HexColor of(String value) {
        return new HexColor(value);
    }

    private static boolean isValidHexCode(String hexCode) {
        return pattern.matcher(hexCode).matches();
    }
}
