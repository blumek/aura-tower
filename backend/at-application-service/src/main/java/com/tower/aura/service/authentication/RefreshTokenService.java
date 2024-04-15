package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.RefreshTokenReply;
import com.tower.aura.api.authentication.RefreshTokenRequest;
import com.tower.aura.api.authentication.RefreshTokenUseCase;
import org.springframework.stereotype.Service;

@Service
class RefreshTokenService implements RefreshTokenUseCase {
    @Override
    public RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest) {
        return null;
    }
}
