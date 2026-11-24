package ie.atu.onlineshopp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    private final JwtAuthenticationFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter) 
    {
        this.jwtAuthFilter = jwtAuthFilter;
    
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

            
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // JWT is stateless
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
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter before the username/password filter

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