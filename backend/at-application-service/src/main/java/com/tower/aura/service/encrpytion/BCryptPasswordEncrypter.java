package com.tower.aura.service.encrpytion;

import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.spi.encryption.PasswordEncrypter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class BCryptPasswordEncrypter implements PasswordEncrypter {
    private final BCryptPasswordEncoder passwordEncoder;

    public BCryptPasswordEncrypter(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApiPassword encrypt(ApiPassword password) {
        return new ApiPassword(passwordEncoder.encode(password.value()));
    }
}
