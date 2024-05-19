package com.tower.aura.rest.web.adapter.controller.support;

import com.auth0.jwt.JWT;
import com.tower.aura.rest.web.adapter.controller.model.RestWebUserIdentifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class RestWebUserIdentifierConverter implements Converter<String, RestWebUserIdentifier> {
    @Override
    public RestWebUserIdentifier convert(String token) {
        return new RestWebUserIdentifier(getUserIdFrom(token));
    }

    private static String getUserIdFrom(String token) {
        final var accessToken = token.substring("Bearer ".length());
        return JWT.decode(accessToken).getClaim("user_id").asString();
    }
}
