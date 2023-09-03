package com.lynas.config

import com.lynas.config.zitadel.ZitadelLogoutHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    @Autowired
    private lateinit var zitadelLogoutHandler: ZitadelLogoutHandler

    @Bean
    fun securityFilterChain(
        httpSecurity: HttpSecurity,
        clientRegistrationRepository: ClientRegistrationRepository
    ): SecurityFilterChain {
        httpSecurity.authorizeHttpRequests {
            it.requestMatchers("/").permitAll()
            it.requestMatchers("/api/logout").permitAll()
            it.requestMatchers("/logout").permitAll()
            it.anyRequest().authenticated()
        }

        httpSecurity.oauth2Login {}
        httpSecurity.logout {
            it.logoutUrl("/logout")
            it.addLogoutHandler(zitadelLogoutHandler)
        }
        httpSecurity.csrf {
            it.disable()
        }
        return httpSecurity.build()
    }
}