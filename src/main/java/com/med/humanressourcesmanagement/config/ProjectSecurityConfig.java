package com.med.humanressourcesmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/login", "/webjars/**", "/h2-console/**","/img/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .failureUrl("/login?error=true")
                                .permitAll())
                .logout(logout ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login?logout=true")
                                .permitAll()
                );
        return http.build();
    }
}
