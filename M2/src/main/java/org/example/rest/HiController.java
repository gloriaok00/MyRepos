package org.example.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {

    @GetMapping("/hi")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String hi() {
        return "hi";
    }

    @GetMapping("/say")
    @Secured({"ROLE_USER"})
    public String say() {
        //Authentication mm=SecurityContextHolder.getContext().getAuthentication();
        return "say";
    }

}
