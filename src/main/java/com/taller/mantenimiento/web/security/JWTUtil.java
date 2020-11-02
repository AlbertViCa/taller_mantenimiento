package com.taller.mantenimiento.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JWTUtil {

    private static final String KEY = "a8-ry-a9r8huds0-435qasre";

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 100 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }
}
