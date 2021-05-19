package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;

import com.apispring.api_spring.service.StudentService;
import com.apispring.api_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getInfo(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/updateInfo")
    public Student updateInfo(@RequestBody Student student) {
        Student oldStudent = studentService.getStudentById(student.getStudentId());


        //Update profile
        oldStudent.setStudentPhone(student.getStudentPhone());
        oldStudent.setStudentAddress(student.getStudentAddress());

        //For update paddword
        Account oldAccount = oldStudent.getAccount();
        oldAccount.setPassword(student.getAccount().getPassword());
        oldStudent.setAccount(oldAccount);
        return studentService.updateInfo(oldStudent);

    }

    @PutMapping("/student/default")
    public Student updateDefault(@RequestBody Student student) {
        Student oldStudent = studentService.getStudentById(student.getStudentId());


        //Update profile
        oldStudent.setStudentPhone(student.getStudentPhone());
        oldStudent.setStudentAddress(student.getStudentAddress());

        oldStudent.setStudentEmail(student.getStudentEmail());
        oldStudent.setClasses(student.getClasses());
        oldStudent.setStudentImage(student.getStudentImage());
        oldStudent.setStudentCode(student.getStudentCode());
        oldStudent.setStudentName(student.getStudentName());
        oldStudent.setStudentBirthday(student.getStudentBirthday());
        //For update paddword
        Account oldAccount = oldStudent.getAccount();
        oldAccount.setPassword(student.getAccount().getPassword());
        oldStudent.setAccount(oldAccount);
        return studentService.updateInfo(oldStudent);

    }
}
