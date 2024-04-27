package com.tower.aura.rest.web.adapter.security;

import com.tower.aura.api.authentication.ValidateAccessTokenRequest;
import com.tower.aura.api.authentication.ValidateAccessTokenUseCase;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
class JwtAccessTokenFilter extends OncePerRequestFilter {
    private final ValidateAccessTokenUseCase validateAccessTokenUseCase;

    JwtAccessTokenFilter(ValidateAccessTokenUseCase validateAccessTokenUseCase) {
        this.validateAccessTokenUseCase = validateAccessTokenUseCase;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final var accessToken = getAccessTokenFrom(request);
        if (accessToken.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }

        final var validationResult = validateAccessTokenUseCase.validate(new ValidateAccessTokenRequest(new ApiJsonWebToken(accessToken.get())));
        if (!validationResult.isValid()) {
            filterChain.doFilter(request, response);
            return;
        }

        authenticate(request, accessToken.get());
        filterChain.doFilter(request, response);
    }

    private static void authenticate(HttpServletRequest request, String accessToken) {
        final var authenticationToken = new BearerTokenAuthenticationToken(accessToken);
        authenticationToken.setAuthenticated(true);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private static Optional<String> getAccessTokenFrom(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(AUTHORIZATION))
                .filter(StringUtils::isNotEmpty)
                .filter(header -> header.startsWith("Bearer "))
                .map(header -> header.split(" ")[1].trim());
    }
}
