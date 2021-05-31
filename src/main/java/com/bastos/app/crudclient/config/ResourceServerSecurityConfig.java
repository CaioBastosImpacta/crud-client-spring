package com.bastos.app.crudclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.bastos.app.crudclient.entrypoint.controller.constants.UrlConstants;

@Configuration
@EnableWebSecurity
public class ResourceServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/",
                "/favicon.ico",
                "/swagger-ui.html", "/swagger-resources/**", "/v2/**",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.svg",
                "/**/*.jpg",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js")
	        .permitAll()
	        .antMatchers(HttpMethod.GET, UrlConstants.URL_HEALTHCHECK)
            .permitAll()
	        .and()
            .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
                .oauth2ResourceServer()
                .jwt();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
