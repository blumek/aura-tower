package com.tower.aura.rest.web.adapter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    private final JwtAccessTokenFilter jwtAccessTokenFilter;

    SecurityConfiguration(JwtAccessTokenFilter jwtAccessTokenFilter) {
        this.jwtAccessTokenFilter = jwtAccessTokenFilter;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(SecurityConfiguration::sessionManagementConfiguration)
                .authorizeHttpRequests(SecurityConfiguration::httpRequestsAuthorizationConfiguration)
                .exceptionHandling(SecurityConfiguration::exceptionHandlerConfiguration)
                .addFilterBefore(jwtAccessTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    private static void sessionManagementConfiguration(SessionManagementConfigurer<HttpSecurity> session) {
        session.sessionCreationPolicy(STATELESS);
    }

    private static void httpRequestsAuthorizationConfiguration(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationConfigurer) {
        authorizationConfigurer
                .requestMatchers(
                        "/v1/authentications/credentials",
                        "/v1/authentications/tokens",
                        "/v1/authentications/refreshed-tokens"
                ).permitAll()
                .anyRequest().authenticated();
    }

    private static void exceptionHandlerConfiguration(ExceptionHandlingConfigurer<HttpSecurity> httpSecurityExceptionHandlingConfigurer) {
        httpSecurityExceptionHandlingConfigurer
                .accessDeniedHandler((request, response, accessDeniedException) -> response.setStatus(FORBIDDEN.value()))
                .authenticationEntryPoint(new HttpStatusEntryPoint(UNAUTHORIZED));
    }
}