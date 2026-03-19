package com.pro.Spring_Boot_Security.Config;

import com.pro.Spring_Boot_Security.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
//basic auth
  /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()

                )
                .httpBasic(basic -> basic.realmName("MyApp"));
              return http.build();


    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user1 = User.withDefaultPasswordEncoder()
                .username("Jhon")
                .password("gigga")
                .roles("NORMAL")
                .build();

        var user2 = User.withDefaultPasswordEncoder()
                .username("De")
                .password("rigga")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }*/

    //role based auth
   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                 .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").hasRole("NORMAL")
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .anyRequest().authenticated()

                )
                .httpBasic(basic -> basic.realmName("MyApp"));
        return http.build();


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(5);
    }
    @Bean
    public UserDetailsService userDetailsService() {
        var user1 = User.builder()
                .username("Jhon")
                .password(this.passwordEncoder().encode("gigga"))
                .roles("NORMAL")
                .build();

        var user2 = User.builder()
                .username("Snith")
                .password(this.passwordEncoder() .encode("rigga"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }*/
    // form based auth
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register").permitAll()

                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .anyRequest().authenticated()

                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/api/home")
                        .permitAll()
                );
        return http.build();


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(5);
    }
    @Bean
    public UserDetailsService userDetailsService() {
        var user1 = User.builder()
                .username("Jhon")
                .password(this.passwordEncoder().encode("gigga"))
                .roles("NORMAL")
                .build();

        var user2 = User.builder()
                .username("Snith")
                .password(this.passwordEncoder() .encode("rigga"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
