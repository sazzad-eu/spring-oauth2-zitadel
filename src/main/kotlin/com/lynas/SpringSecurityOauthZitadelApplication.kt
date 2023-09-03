package com.lynas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class SpringSecurityOauthZitadelApplication {

	@Bean
	fun restTemplate()  = RestTemplate()
}

fun main(args: Array<String>) {
	runApplication<SpringSecurityOauthZitadelApplication>(*args)
}
