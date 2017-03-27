package com.zebra.emc.tools.ReadingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Configuration: Indicates that this class can be used by IoC container
 * @EnableWebSecurity: Add this to an @Configuration calss to have the Spring Security
 * configuration defined in any WebSecurityConfigurer or more likely by extending the
 * WebSecurityConfigurerAdapter base class
 *
 * SecurityConfig is a very basic Spring Security configuration. By providing this custom
 * security configuration class, we are asking Spring Boot to skip security auto-configuration
 * and to use our security configuration instead.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    /*
     * Specifies requests for "/" require an authenticated user with the READER role.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").access("hasRole('READER')")
            .antMatchers("/**").permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=true");
    }

    /*
     * Set a custom user details service.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(new UserDetailsService(){
               @Override
                public UserDetails loadUserByUsername(String username) throws
                   UsernameNotFoundException {
                   return readerRepository.findOne(username);
               }
            });
    }

}
