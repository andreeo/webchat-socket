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

/**
 * Configuration class for loading user details from a CSV file.
 * This class sets up an in-memory user details manager populated with users
 * read from a CSV file at application startup.
 */
@Configuration
public class UserConfig {

    /**
     * Creates an in-memory user details service that reads user details from a CSV file.
     * The CSV file should be located at the root of the classpath and named "users.csv".
     * Each line in the CSV file should contain the username, password, and level, separated by commas.
     *
     * @return an instance of UserDetailsService populated with users from the CSV file
     * @throws IOException if an error occurs while reading the CSV file
     */
    @Bean
    public UserDetailsService userDetailsService() throws IOException {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        try (CSVReader reader = new CSVReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("users.csv"))))) {
            String[] line;
            while((line = reader.readNext()) != null) {
                String username = line[0];
                // Prefix with {noop} to indicate no password encoding
                String password = "{noop}" + line[1];
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
