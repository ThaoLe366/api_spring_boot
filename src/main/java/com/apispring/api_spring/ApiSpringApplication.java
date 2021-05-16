package com.apispring.api_spring;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.respository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ApiSpringApplication {
    @Autowired
    private AccountRepository repository;

    @PostConstruct
    public void initUsers() {

    }

    public static void main(String[] args) {
        SpringApplication.run(ApiSpringApplication.class, args);
    }

}
