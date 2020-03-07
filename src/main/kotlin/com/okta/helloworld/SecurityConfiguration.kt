package com.okta.helloworld

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@EnableWebSecurity
class SecurityConfiguration: WebSecurityConfigurerAdapter() {
    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("john.doe")
                .password(passwordEncoder().encode("secret"))
                .roles("USER")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return passwordEncoder
    }
}