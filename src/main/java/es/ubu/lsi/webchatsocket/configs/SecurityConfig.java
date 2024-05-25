package es.ubu.lsi.webchatsocket.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security
 * This class sets up the security configuration for the application,
 * including security filter chain
 */
public class SecurityConfig {

    /**
     * Configures the security filter chain
     * This method sets up the HTTP security for the application, requiring authentication
     * for all requests, enabling form-based login, and allowing HTTP Basic authentication.
     *
     * @param http the HttpSecurity
     * @return the SecurityFilterChain that defines the application's security policy
     * @throws Exception Exception if an error occurs while configuring the HttpSecurity
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .authorizeHttpRequests(authorizeHttpRequests ->
                       authorizeHttpRequests
                               .anyRequest()
                               .authenticated())
               .formLogin(formLogin -> formLogin.defaultSuccessUrl("/"))
               .httpBasic(Customizer.withDefaults()).build();
    }
}
