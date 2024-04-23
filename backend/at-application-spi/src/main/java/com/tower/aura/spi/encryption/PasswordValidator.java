package com.tower.aura.spi.encryption;

import com.tower.aura.api.authentication.model.ApiPassword;

public interface PasswordValidator {
    boolean matches(ApiPassword password, ApiPassword otherPassword);
}
