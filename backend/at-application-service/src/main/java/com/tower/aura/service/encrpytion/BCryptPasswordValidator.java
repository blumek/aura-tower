package com.tower.aura.service.encrpytion;

import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.spi.encryption.PasswordValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class BCryptPasswordValidator implements PasswordValidator {
    private final BCryptPasswordEncoder passwordEncoder;

    public BCryptPasswordValidator(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean matches(ApiPassword password, ApiPassword otherPassword) {
        return passwordEncoder.matches(password.value(),otherPassword.value());
    }
}
