package es.ubu.lsi.webchatsocket.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

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
