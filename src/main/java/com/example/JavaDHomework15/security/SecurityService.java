package com.example.JavaDHomework15.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String password;

    public Boolean cheker(String inUsername, String inPassword){
        if(inUsername.equals(username) && inPassword.equals(password)){
            return true;
        }
        return false;
    }
}
