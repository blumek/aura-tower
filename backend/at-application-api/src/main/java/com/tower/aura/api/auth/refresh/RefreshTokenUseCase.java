package com.tower.aura.api.auth.refresh;

public interface RefreshTokenUseCase {
    RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest);
}
