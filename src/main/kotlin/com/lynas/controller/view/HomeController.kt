package com.lynas.controller.view

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

    @RequestMapping("/")
    fun root() : String {
        return "index"
    }
}