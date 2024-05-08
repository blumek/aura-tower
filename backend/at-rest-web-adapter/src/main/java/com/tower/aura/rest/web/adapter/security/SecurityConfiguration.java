package com.tower.aura.rest.web.adapter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    private final JwtAccessTokenFilter jwtAccessTokenFilter;
    private final CorsSettings corsSettings;

    SecurityConfiguration(JwtAccessTokenFilter jwtAccessTokenFilter, CorsSettings corsSettings) {
        this.jwtAccessTokenFilter = jwtAccessTokenFilter;
        this.corsSettings = corsSettings;
    }

    @Bean
    AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(this::httpSecurityCorsConfiguration)
                .sessionManagement(SecurityConfiguration::sessionManagementConfiguration)
                .authorizeHttpRequests(SecurityConfiguration::httpRequestsAuthorizationConfiguration)
                .exceptionHandling(SecurityConfiguration::exceptionHandlerConfiguration)
                .addFilterBefore(jwtAccessTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    private void httpSecurityCorsConfiguration(CorsConfigurer<HttpSecurity> httpSecurityCorsConfigurer) {
        httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource());
    }

    private CorsConfigurationSource corsConfigurationSource() {
        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration());
        return source;
    }

    private CorsConfiguration corsConfiguration() {
        final var corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(corsSettings.allowedOrigins());
        corsConfiguration.setAllowedMethods(corsSettings.allowedMethods());
        corsConfiguration.setExposedHeaders(corsSettings.exposedHeaders());
        corsConfiguration.setAllowedHeaders(corsSettings.allowedHeaders());
        corsConfiguration.setMaxAge(corsSettings.maxAge());
        corsConfiguration.setAllowCredentials(corsSettings.allowCredentials());
        return corsConfiguration;
    }

    private static void sessionManagementConfiguration(SessionManagementConfigurer<HttpSecurity> session) {
        session.sessionCreationPolicy(STATELESS);
    }

    private static void httpRequestsAuthorizationConfiguration(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationConfigurer) {
        authorizationConfigurer
                .requestMatchers(
                        "/v1/authentications/credentials",
                        "/v1/authentications/tokens",
                        "/v1/authentications/refreshed-tokens",
                        "/v1/catalogs/reminder-questions",
                        "/swagger-ui/**",
                        "/v3/api-docs/**"
                ).permitAll()
                .anyRequest().authenticated();
    }

    private static void exceptionHandlerConfiguration(ExceptionHandlingConfigurer<HttpSecurity> httpSecurityExceptionHandlingConfigurer) {
        httpSecurityExceptionHandlingConfigurer
                .accessDeniedHandler((request, response, accessDeniedException) -> response.setStatus(FORBIDDEN.value()))
                .authenticationEntryPoint(new HttpStatusEntryPoint(UNAUTHORIZED));
    }
}