package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.OffRequest;
import com.apispring.api_spring.service.OffRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OffRequestController {

    @Autowired
    private OffRequestService service;

    @PostMapping("/offRequest")
    public OffRequest save(@RequestBody OffRequest offRequest){
        return service.save(offRequest);
    }

    @GetMapping("/offRequest")
    public List<OffRequest> findAll(){
        return service.findAll();
    }

    @GetMapping("/offRequest/{teacherId}")
    public  List<OffRequest> findByTeacherId(@PathVariable String teacherId){
        return  service.findBySenderId(teacherId);
    }

    @DeleteMapping("/offRequest")
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("/offRequest/{teacherId}")
    public void deleteByTeacherId(@PathVariable String teacherId){
        service.deleteByTeacherId(teacherId);
    }
}
