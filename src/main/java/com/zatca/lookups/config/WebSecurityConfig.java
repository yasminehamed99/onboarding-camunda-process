package com.zatca.lookups.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${cors.allowed.origins}")
    private String allowedOrigins;

    @Value("${cors.allowed.methods}")
    private String allowedMethods;

    @Value("${cors.allowed.headers}")
    private String allowedHeaders;

    @Value("${cors.exposed.headers}")
    private String exposedHeaders;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
                .authenticated().and().csrf().disable().cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        if (StringUtils.isNotBlank(allowedOrigins)) {
            configuration.setAllowedOrigins(Arrays.asList(allowedOrigins.split(",")));
        }

        if (StringUtils.isNotBlank(allowedMethods)) {
            configuration.setAllowedMethods(Arrays.asList(allowedMethods.split(",")));
        }

        if (StringUtils.isNotBlank(allowedHeaders)) {
            configuration.setAllowedHeaders(Arrays.asList(allowedHeaders.split(",")));
        }

        if (StringUtils.isNotBlank(exposedHeaders)) {
            configuration.setExposedHeaders(Arrays.asList(exposedHeaders.split(",")));
        }

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

