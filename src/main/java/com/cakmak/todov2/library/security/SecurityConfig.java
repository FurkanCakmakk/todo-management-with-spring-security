package com.cakmak.todov2.library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // VERSION 1 FOLKSDEV

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder()
//                .username("user")
//                .password(bCryptPasswordEncoder().encode("user"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(bCryptPasswordEncoder().encode("admin "))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, admin);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
//        security
//                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(x -> x.requestMatchers("/todos").permitAll())
//                .authorizeHttpRequests(x -> x.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//
//        return security.build();
//
//    }

    // VERSION 2 FOLKSDEV

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        security
                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x -> x.requestMatchers("/todos").permitAll())
                .authorizeHttpRequests(x -> x.requestMatchers("/users/**").permitAll())
                .authorizeHttpRequests(x -> x.anyRequest().authenticated())
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        return security.build();
    }

}
