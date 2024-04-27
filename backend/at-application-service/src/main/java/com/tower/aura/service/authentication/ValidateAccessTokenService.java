package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.ValidateAccessTokenRequest;
import com.tower.aura.api.authentication.ValidateAccessTokenResponse;
import com.tower.aura.api.authentication.ValidateAccessTokenUseCase;
import org.springframework.stereotype.Service;

@Service
class ValidateAccessTokenService implements ValidateAccessTokenUseCase {
    @Override
    public ValidateAccessTokenResponse validate(ValidateAccessTokenRequest validateAccessTokenRequest) {
        return new ValidateAccessTokenResponse(true);
    }
}
