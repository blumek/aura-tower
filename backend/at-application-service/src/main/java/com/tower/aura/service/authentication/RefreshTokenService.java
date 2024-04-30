package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.RefreshTokenReply;
import com.tower.aura.api.authentication.RefreshTokenRequest;
import com.tower.aura.api.authentication.RefreshTokenUseCase;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;
import com.tower.aura.api.authentication.model.ApiUserIdentifier;
import com.tower.aura.api.authentication.model.ApiUsername;
import com.tower.aura.spi.authentication.jwt.JwtCreateRequest;
import com.tower.aura.spi.authentication.jwt.JwtTokenPairCreator;
import org.springframework.stereotype.Service;

@Service
class RefreshTokenService implements RefreshTokenUseCase {
    private final JwtTokenPairCreator jwtTokenPairCreator;

    RefreshTokenService(JwtTokenPairCreator jwtTokenPairCreator) {
        this.jwtTokenPairCreator = jwtTokenPairCreator;
    }

    @Override
    public RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest) {
        return new RefreshTokenReply(generateJwtTokenPair());
    }

    private ApiJsonWebTokenPair generateJwtTokenPair() {
        return jwtTokenPairCreator.create(new JwtCreateRequest(
                new ApiUserIdentifier("identifier"),
                new ApiUsername("username")
        ));
    }
}
