package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     @Bean
     public UserDetailsService userDetailsService(){
         InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
         PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
         log.info("Password: {}", encoder.encode("123"));
         manager.createUser(User.withUsername("dev").password(encoder.encode("123")).authorities("p1").build());
         return manager;
     }
}
