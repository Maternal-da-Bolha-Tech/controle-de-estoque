package com.maternal.controle_estoques.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Desativa os filtros de segurança padrões do Spring Security, apenas para facilitar a fase de desenvolvimento.
 */
@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain disableSecurityFilters(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll())
      .csrf(AbstractHttpConfigurer::disable)
      .httpBasic(AbstractHttpConfigurer::disable)
      .formLogin(AbstractHttpConfigurer::disable);
    return httpSecurity.build();
  }
}
