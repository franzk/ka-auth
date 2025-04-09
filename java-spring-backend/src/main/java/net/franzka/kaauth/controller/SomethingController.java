package net.franzka.kaauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SomethingController {

    @GetMapping("/something")
    @PreAuthorize("hasRole('user')")
    public String something() {
        return "something";
    }

    @GetMapping("/me")
    public Object me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

}
