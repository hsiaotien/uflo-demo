package com.coinceres.uflodemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @PostMapping("/doLogin")
    public Object login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null) {
            throw new RuntimeException("login fail!");
        }
        request.getSession().setAttribute("loginUser",username);
        return null;
    }
}
