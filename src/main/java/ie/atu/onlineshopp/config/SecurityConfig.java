package ie.atu.onlineshopp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

             .headers(headers -> headers.frameOptions(frame -> frame.disable()))
             
            .csrf(csrf -> csrf.disable()) // Disables CSRF so POST requests work
            .authorizeHttpRequests(auth -> auth
                // Allow anyone to GET products
                .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
                
                // ONLY allow ADMIN to POST products
                .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("ADMIN")
                
                // Allow Swagger UI to load
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                
                // Any other request needs login
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()); 

        return http.build();
    }

    // Hardcoded users for testing (Will be replaced with a database in the future)
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password123")
                .roles("ADMIN")
                .build();
                
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}