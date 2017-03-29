package com.ludwigwiren

import com.sun.deploy.util.SearchPath.findOne
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException


    var a = Reader()
// Created by ludwi on date 2017-03-29

@Configuration
@EnableWebSecurity
class SecurityConfig(val readerRepository: ReaderRepo) : WebSecurityConfigurerAdapter() {


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
    }

    @Throws(Exception::class)
    override fun configure(
            auth: AuthenticationManagerBuilder) {
        auth
                .userDetailsService(UserDetailsService { username -> readerRepository.findOne!!(username) })
    }
}