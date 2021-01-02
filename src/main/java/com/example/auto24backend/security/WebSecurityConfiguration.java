package com.example.auto24backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.example.auto24backend.service.MyAccountDetailService;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private MyAccountDetailService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers(HttpMethod.GET, "/api/ads").permitAll()
                .antMatchers("/api/ads/search").permitAll()
                .antMatchers(HttpMethod.GET,"/api/carMarks").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/carMarks").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/carMarks").permitAll()
                .antMatchers(HttpMethod.POST, "/api/ads").permitAll()
//                .antMatchers(HttpMethod.POST, "/registerAdmin").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/registerAdmin").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .loginProcessingUrl("/perform_login")
                .successHandler(authenticationSuccessHandler)
                .failureUrl("http://13.53.200.72/login?error=true")
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .headers().httpStrictTransportSecurity().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
