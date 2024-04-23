package com.tower.aura.spi.encryption;

import com.tower.aura.api.authentication.model.ApiPassword;

public interface PasswordEncrypter {
    ApiPassword encrypt(ApiPassword password);
}
