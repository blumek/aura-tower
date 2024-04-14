package com.tower.aura.api.auth;

public interface RefreshTokenUseCase {
    RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest);
}
