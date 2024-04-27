package com.tower.aura.rest.web.adapter.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class BearerTokenAuthenticationToken extends AbstractAuthenticationToken {
    private final String token;

    public BearerTokenAuthenticationToken(String token) {
        super(Collections.emptyList());
        if (isBlank(token)) {
            throw new IllegalArgumentException("Token cannot be blank");
        }

        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.getToken();
    }

    @Override
    public Object getPrincipal() {
        return this.getToken();
    }

}
