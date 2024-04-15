package com.tower.aura.api.authentication;

public interface RefreshTokenUseCase {
    RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest);
}
