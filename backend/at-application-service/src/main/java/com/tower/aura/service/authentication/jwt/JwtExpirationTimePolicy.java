package com.tower.aura.service.authentication.jwt;

import java.time.Duration;

public interface JwtExpirationTimePolicy {
    Duration expirationTime();
}
