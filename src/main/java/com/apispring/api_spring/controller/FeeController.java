package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.FeeperCredit;
import com.apispring.api_spring.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeeController {

    @Autowired
    private FeeService feeService;

    @PostMapping("/fee")
    public FeeperCredit save(@RequestBody FeeperCredit feeperCredit){
        return feeService.save(feeperCredit);
    }

    @GetMapping("/fee")
    public List<FeeperCredit> findAll(){
       return feeService.findAll();
    }

    @GetMapping("/fee/{year}")
    public FeeperCredit findByYear(@PathVariable int year){
        return feeService.findById(year);
    }

    @DeleteMapping("/fee/{year}")
    public void deleteByYear(@PathVariable int year){
        feeService.deleteById(year);
    }
}
