package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;

import com.apispring.api_spring.service.StudentService;
import com.apispring.api_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> findAll (){ return  studentService.findAll();}

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getInfo(@PathVariable String  id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/updateInfo")
    public Student updateInfo(@RequestBody Student student) {

        return studentService.updateInfo(student);

    }

    @PutMapping("/student/default")
    public Student updateDefault(@RequestBody Student student) {
        return studentService.updateDefault(student);

    }
}
