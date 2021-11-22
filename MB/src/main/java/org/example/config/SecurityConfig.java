package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     @Bean
     public UserDetailsService userDetailsService(){
         InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
         PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
         manager.createUser(User.withUsername("admin").password(encoder.encode("admin")).authorities("p1").roles("ADMIN").build());
         manager.createUser(User.withUsername("user").password(encoder.encode("user")).authorities("p2").roles("USER").build());
         return manager;
     }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/home").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/hello").hasRole("USER");
        http.formLogin();
    }
}
