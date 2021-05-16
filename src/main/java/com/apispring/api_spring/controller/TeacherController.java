package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @GetMapping("/teacher/{id}")
    public Teacher getInfo(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }
}
