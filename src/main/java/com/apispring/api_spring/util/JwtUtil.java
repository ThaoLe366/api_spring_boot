package com.apispring.api_spring.util;

import com.apispring.api_spring.entity.Parent;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Jwts;



@Service
public class JwtUtil {
    //Guider of this turtorial
    private String secret = "javatechie";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

//    public String generateToken(String username) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, username);
//    }



    public String generateToken(Teacher teacher) throws JsonProcessingException {
        Map<String, Object> claims = new HashMap<>();


        ObjectMapper objectMapper = new ObjectMapper(); // or use an existing one
        String json = objectMapper.writeValueAsString(teacher);
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);

        String base64 = Base64.getEncoder().encodeToString(bytes);

      return   Jwts.builder().claim("userJsonBase64", base64).setSubject(String.valueOf(teacher.getAccount().getUsername())).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();

    }

    public String generateToken(Student student) throws JsonProcessingException {
        Map<String, Object> claims = new HashMap<>();


        ObjectMapper objectMapper = new ObjectMapper(); // or use an existing one
        String json = objectMapper.writeValueAsString(student);
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);

        String base64 = Base64.getEncoder().encodeToString(bytes);

        return   Jwts.builder().claim("userJsonBase64", base64).setSubject(String.valueOf(student.getAccount().getUsername())).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();

    }
    public String generateToken(Parent parent) throws JsonProcessingException {
        Map<String, Object> claims = new HashMap<>();


        ObjectMapper objectMapper = new ObjectMapper(); // or use an existing one
        String json = objectMapper.writeValueAsString(parent);
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);

        String base64 = Base64.getEncoder().encodeToString(bytes);

        return   Jwts.builder().claim("userJsonBase64", base64).setSubject(String.valueOf(parent.getAccount().getUsername())).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();

    }


    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
//    private String createToken(Map<String, Object> claims, Teacher teacher) {
//
//        return Jwts.builder().setClaims(claims).setSubject(teacher.toString()).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, secret).compact();
//    }
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
