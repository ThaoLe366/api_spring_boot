package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.*;
import com.apispring.api_spring.service.CustomUserDetailService;
import com.apispring.api_spring.service.ParentService;
import com.apispring.api_spring.service.StudentService;
import com.apispring.api_spring.service.TeacherService;
import com.apispring.api_spring.util.JwtUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ParentService parentService;

    @Autowired
    StudentService studentService;

    @GetMapping("/account/{id}")
    public Account getInfoAccount(@PathVariable int id) {
        return userDetailService.getAccountById(id);
    }

    @PostMapping("/register/{role}")
    public Account register(@RequestBody Account account,@PathVariable int role ) {

        if(role==1){ //Teacher
            Account account1=  userDetailService.createUser(account);
            Teacher newTeacher= new Teacher();
            newTeacher.setAccountID(account1.getId());
            teacherService.createTeacher(newTeacher);
            return account1;
        }
        else if(role==2){ //Student
            Account account2=  userDetailService.createUser(account);
            Student newStudent= new Student();
            newStudent.setAccountID(account2.getId());
            studentService.createStudent(newStudent);
            return account2;
        }
        else{  //role=3: Parent
            Account account3=  userDetailService.createUser(account);
            Parent newParent= new Parent();
            newParent.setAccountID(account3.getId());
            parentService.createParent(newParent);
            return account3;
        }
       // return "Form Teacher not successful";
    }

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                            authRequest.getPassword()));


        } catch (Exception ex) {
            throw new Exception("invalid username/password");

        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
