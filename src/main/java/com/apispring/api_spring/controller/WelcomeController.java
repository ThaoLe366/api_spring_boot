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

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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
            newTeacher.setTeacherID(Calendar.getInstance().getTime().toString());
            newTeacher.setAccount(account1);
            teacherService.createTeacher(newTeacher);
            return account1;
        }
        else if(role==2){ //Student
            Account account2=  userDetailService.createUser(account);
            Student newStudent= new Student();

            //Create random id
            //TODO: generate password spring
            Date currentTime    = Calendar.getInstance().getTime();
            String randomPasswordStudent=currentTime.toString();
            newStudent.setStudentId(randomPasswordStudent);
            newStudent.setAccount(account2);
            studentService.createStudent(newStudent);


            String emailDefault= "parent_" +account.getUsername();
            //Create Parent account
            Random r = new Random();
            String passwordDefault=String.valueOf(r.nextInt(12000-10000)+10000);

            String randomPasswordParent= (Calendar.getInstance().getTime()).toString();

            Account accountParent= new Account(emailDefault, passwordDefault);
            userDetailService.createUser(accountParent);

            Parent parent= new Parent();
            parent.setParentId(randomPasswordParent);
            parent.setStudent(newStudent);

            parent.setAccount(accountParent);
            parentService.createParent(parent);
            return account2;
        }
        return null;
       // return "Form Teacher not successful";
    }

    @PostMapping("/login")
    public AuthenticatonToken generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                            authRequest.getPassword()));


        } catch (Exception ex) {
            throw new Exception(ex.toString());

        }
        String token=jwtUtil.generateToken(authRequest.getUserName());
        AuthenticatonToken authenticatonToken= new AuthenticatonToken(token);
        return authenticatonToken;
    }
}
