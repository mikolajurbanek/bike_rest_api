package com.codecool.bike_rest_api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
                http.authorizeRequests().antMatchers("/", "/index").permitAll().antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/login")
                .permitAll();

    }
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
//                .withDefaultSchema()
                .dataSource(dataSource)
//                .withUser("test")
//                .password("{bcrypt}" + new BCryptPasswordEncoder().encode("test"))
//                .roles("ADMIN")
//                .and()
                .usersByUsernameQuery("select email, password, true from user_login_details where email=?")
                .authoritiesByUsernameQuery("select l.email as principal, r.role as role\n" +
                        "from user_login_details l, roles r\n" +
                        "where l.id=r.user_id and email=?;\n" +
                        ";\n")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // TODO Auto-generated method stub
        return new BCryptPasswordEncoder();
    }

}
