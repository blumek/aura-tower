package com.tower.aura.rest.web.adapter.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ConfigurationProperties(prefix = "aura-tower.security.cors")
class CorsSettings {
    private final List<String> allowedOrigins;
    private final List<String> allowedMethods;
    private final List<String> allowedHeaders;
    private final List<String> exposedHeaders;
    private final Duration maxAge;

    public CorsSettings(List<String> allowedOrigins, List<String> allowedMethods,
                        List<String> allowedHeaders, List<String> exposedHeaders,
                        Duration maxAge) {
        this.allowedOrigins = Optional.ofNullable(allowedOrigins).orElseGet(List::of);
        this.allowedMethods = Optional.ofNullable(allowedMethods).orElseGet(List::of);
        this.allowedHeaders = Optional.ofNullable(allowedHeaders).orElseGet(List::of);
        this.exposedHeaders = Optional.ofNullable(exposedHeaders).orElseGet(List::of);
        this.maxAge = maxAge;
    }

    public List<String> allowedOrigins() {
        return allowedOrigins;
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

    public Duration maxAge() {
        return maxAge;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CorsSettings that)) return false;
        return Objects.equals(allowedOrigins, that.allowedOrigins)
                && Objects.equals(allowedMethods, that.allowedMethods)
                && Objects.equals(allowedHeaders, that.allowedHeaders)
                && Objects.equals(exposedHeaders, that.exposedHeaders)
                && Objects.equals(maxAge, that.maxAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedOrigins,
                allowedMethods,
                allowedHeaders,
                exposedHeaders,
                maxAge);
    }

    @Override
    public String toString() {
        return "CorsSettings{" +
                "allowedOrigins=" + allowedOrigins +
                ", allowedMethods=" + allowedMethods +
                ", allowedHeaders=" + allowedHeaders +
                ", exposedHeaders=" + exposedHeaders +
                ", maxAge=" + maxAge +
                '}';
    }
}
