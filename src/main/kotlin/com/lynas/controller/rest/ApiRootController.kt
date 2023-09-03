package com.lynas.controller.rest

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiRootController {

    @GetMapping("/")
    fun root() = "API root"

    @GetMapping("/logout")
    fun logout(): String {
        return "You are logged out"
    }

    @GetMapping("/private")
    fun private(authentication: Authentication): Map<*, *> {

        return mapOf(
            "auth" to authentication
        )
    }
}