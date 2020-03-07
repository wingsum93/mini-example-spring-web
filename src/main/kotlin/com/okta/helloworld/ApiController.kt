package com.okta.helloworld

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.security.Principal


@Controller
class ApiController {
    @GetMapping(path = ["/", "hello"])
    fun helloWorld(principal: Principal, model: Model): String? {
        model.addAttribute("name", principal.name)
        return "hello-world"
    }
}

