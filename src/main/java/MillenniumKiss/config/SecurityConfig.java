package MillenniumKiss.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        System.out.println("<<<<<<<<<<<< SecurityConfig Loaded >>>>>>>>>>>>>");

        http
            // Enable CORS
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))

            // Disable CSRF
            .csrf(csrf -> csrf.disable())

            // Allow all requests for now
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().permitAll()
            )

            // Disable Spring Boot login page
            .formLogin(form -> form.disable())

            // Disable HTTP Basic popup
            .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        // React Vite frontend
        configuration.setAllowedOrigins(
            Arrays.asList("http://localhost:5173",
            	
            		"https://fee-manegement-n9s4.vercel.app")
        );

        // HTTP methods
        configuration.setAllowedMethods(
            Arrays.asList(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS"
            )
        );

        // Headers
        configuration.setAllowedHeaders(
            Arrays.asList("*")
        );

        // Allow cookies/authentication if needed later
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
            "/**",
            configuration
        );

        return source;
    }
}