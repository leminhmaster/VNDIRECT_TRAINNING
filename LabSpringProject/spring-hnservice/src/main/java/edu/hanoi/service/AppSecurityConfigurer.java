package edu.hanoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("nguoidung").password("{noop}123456").roles("USER")
                .and().withUser("quantri").password("{noop}123456").roles("ADMIN","USER").and()
                .and().authenticationProvider(customAuthenticationProvider);

    }

    @Autowired
    AuthenticationProvider customAuthenticationProvider;
//    @Bean
//    public AuthenticationProvider customAuthenticationProvider() {
//        return new HnUserAuthProvider();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .hasRole("USER")
                .antMatchers("/")

                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        //http.authorizeRequests().antMatchers("/").hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
    }
}

