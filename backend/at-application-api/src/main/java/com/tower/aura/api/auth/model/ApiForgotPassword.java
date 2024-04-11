package com.tower.aura.api.auth.model;

public record ApiForgotPassword(ApiForgotPasswordIdentifier passwordIdentifier,
                                ApiForgotPasswordAnswer passwordAnswer) {
    public ApiForgotPassword {
        if (passwordIdentifier == null) {
            throw new IllegalArgumentException("Forgot value value is required");
        }

        if (passwordAnswer == null) {
            throw new IllegalArgumentException("Forgot value value is required");
        }
    }
}
