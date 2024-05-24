package es.ubu.lsi.webchatsocket.configs;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService() throws IOException {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        try (CSVReader reader = new CSVReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("users.csv"))))) {
            String[] line;
            while((line = reader.readNext()) != null) {
                String username = line[0];
                String password ="{noop}" + line[1];
                String role = line[2];
                manager.createUser(User.builder()
                        .username(username)
                        .password(password)
                        .roles(role)
                        .build());
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return manager;
    }
}
