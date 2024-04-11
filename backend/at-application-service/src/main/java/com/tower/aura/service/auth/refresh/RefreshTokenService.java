package com.tower.aura.service.auth.refresh;

import com.tower.aura.api.auth.refresh.RefreshTokenReply;
import com.tower.aura.api.auth.refresh.RefreshTokenRequest;
import com.tower.aura.api.auth.refresh.RefreshTokenUseCase;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService implements RefreshTokenUseCase {
    @Override
    public RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest) {
        return null;
    }
}
