package ir.piana.dev.pianasms.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 7/22/2019 11:06 AM
 **/
@Configuration
@Order(0)
public class PianaConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "xsrf-token", "cookie", "set-cookie"));
//        configuration.setExposedHeaders(Arrays.asList("authorization", "content-type", "xsrf-token", "cookie", "set-cookie"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600l);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
