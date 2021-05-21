package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Parent;
import com.apispring.api_spring.entity.Student;
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
    public Parent getInfoParent(@PathVariable String id) {
        return parentService.getParentById(id);
    }

    @GetMapping("/parent/student/{id}")
    public Parent getParentByChildrenId(@PathVariable String id) {

        return parentService.getParentByChildrenID(id);
    }


    @PutMapping("/parent/updateInfo")
    public Parent updateInfo(@RequestBody Parent parent) {
        return parentService.updateInfo(parent);
    }

    @PutMapping("/parent/default")
    public Parent updateDefault(@RequestBody Parent parent) {
        return parentService.updateDefault(parent);
    }
}
