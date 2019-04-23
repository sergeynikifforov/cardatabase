package com.packt.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.packt.cardatabase.service.UserDetailServiceImpl;

// The @Configuration and @EnableWebSecurity annotations switch off the default web security configuration
// and we can define our own configuration in this class.
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailService;


    // Add a new configureGlobal method to enable users from the database.
    // We shouldn't ever save the password as plain text to the database.
    // Therefore, we will define a password hashing algorithm in the configureGlobal method.
    // In this example, we are using the BCrypt algorithm.
    // This can be easily implemented with the Spring Security BCryptPasswordEncoder class.
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailService)
        .passwordEncoder(new BCryptPasswordEncoder());
    }

    // Inside the configure(HttpSecurity http) method, we can define which endpoints in our
    // application are secured and which are not.
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception{

    }
    */
    //The following is the source code of the method and it will create an in-memory user with the
    //username user and password password:
    /*
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
    */
}
