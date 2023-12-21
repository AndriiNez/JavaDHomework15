package com.example.JavaDHomework15.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityService securityService;

    @RequestMapping("/")
    public RedirectView login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (securityService.cheker(username, password)) {
            return new RedirectView("/note/list");
        }
        return new RedirectView("/login");
    }
}

