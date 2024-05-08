package com.tower.aura.rest.web.adapter.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@ConfigurationProperties(prefix = "aura-tower.security.cors")
class CorsSettings {
    private final List<String> allowedOrigins;
    private final List<String> allowedOriginPatterns;
    private final List<String> allowedMethods;
    private final List<String> allowedHeaders;
    private final List<String> exposedHeaders;
    private final boolean allowCredentials;
    private final Duration maxAge;

    public CorsSettings(List<String> allowedOrigins, List<String> allowedOriginPatterns,
                        List<String> allowedMethods, List<String> allowedHeaders,
                        List<String> exposedHeaders, boolean allowCredentials, Duration maxAge) {
        this.allowedOrigins = Optional.ofNullable(allowedOrigins).orElseGet(List::of);
        this.allowedOriginPatterns = Optional.ofNullable(allowedOriginPatterns).orElseGet(List::of);
        this.allowedMethods = Optional.ofNullable(allowedMethods).orElseGet(List::of);
        this.allowedHeaders = Optional.ofNullable(allowedHeaders).orElseGet(List::of);
        this.exposedHeaders = Optional.ofNullable(exposedHeaders).orElseGet(List::of);
        this.allowCredentials = allowCredentials;
        this.maxAge = maxAge;
    }

    public List<String> allowedOrigins() {
        return allowedOrigins;
    }

    public List<String> allowedOriginPatterns() {
        return allowedOriginPatterns;
    }

    public List<String> allowedMethods() {
        return allowedMethods;
    }

    public List<String> allowedHeaders() {
        return allowedHeaders;
    }

    public List<String> exposedHeaders() {
        return exposedHeaders;
    }

    public boolean allowCredentials() {
        return allowCredentials;
    }

    public Duration maxAge() {
        return maxAge;
    }
}
