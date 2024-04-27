package com.tower.aura.api.authentication;

public interface ValidateAccessTokenUseCase {
    ValidateAccessTokenResponse validate(ValidateAccessTokenRequest validateAccessTokenRequest);
}
