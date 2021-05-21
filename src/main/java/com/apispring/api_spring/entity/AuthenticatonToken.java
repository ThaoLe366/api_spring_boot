package com.apispring.api_spring.entity;

import com.apispring.api_spring.util.JwtUtil;

public class AuthenticatonToken {
    private  String jwt;

    public String getJwt() {
        return jwt;
    }

    public AuthenticatonToken(){

    }
    public AuthenticatonToken(String token){
        this.jwt=token;
    }
}
