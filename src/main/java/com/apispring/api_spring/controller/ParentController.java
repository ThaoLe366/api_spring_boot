package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Parent;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.ParentRepository;
import com.apispring.api_spring.service.ParentService;
import com.apispring.api_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParentController {
@Autowired
private ParentService parentService;

    @PostMapping("/parent")
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.createParent(parent);
    }

    @GetMapping("/parent/{id}")
    public Parent getInfoTeacher(@PathVariable String id) {
        int castId= Integer.parseInt(id);
        return parentService.getParentById(castId);
    }
}
