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
    public Account register(@RequestBody Account account, @PathVariable int role) {

        if (role == 1) { //Teacher
            Account account1 = userDetailService.createUser(account);
            Teacher newTeacher = new Teacher();

            newTeacher.setAccount(account1);
            newTeacher.setTeacherID("Teacher" + String.valueOf(account1.getAccountId()));
            teacherService.createTeacher(newTeacher);
            return account1;
        } else if (role == 2) { //Student
            Account account2 = userDetailService.createUser(account);
            Student newStudent = new Student();

            //Create random id
            //TODO: generate password spring
            newStudent.setStudentId("Student" + String.valueOf(account2.getAccountId()));
            newStudent.setAccount(account2);
            studentService.createStudent(newStudent);


            String emailDefault = "Parent" + account.getUsername();
            //Create Parent account
            Random r = new Random();
            String passwordDefault = String.valueOf(r.nextInt(12000 - 10000) + 10000);

            String randomPasswordParent = (Calendar.getInstance().getTime()).toString();

            Account accountParent = new Account(emailDefault, passwordDefault);
            userDetailService.createUser(accountParent);

            Parent parent = new Parent();
            parent.setParentId(randomPasswordParent);
            parent.setStudent(newStudent);
    
            parent.setAccount(accountParent);
            parentService.createParent(parent);
            return account2;
        }
        return null;
        // return "Form Teacher not successful";
    }

    @PostMapping("/login/{role}")
    public AuthenticatonToken generateToken(@RequestBody AuthRequest authRequest, @PathVariable int role) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                            authRequest.getPassword()));


        } catch (Exception ex) {
            throw new Exception(ex.toString());

        }

        if (role == 1)        //Teacher
        {
            Teacher teacher = new Teacher();
            teacher = userDetailService.findTeacherByUserName(authRequest.getUserName());
            String token = jwtUtil.generateToken(teacher);
            AuthenticatonToken authenticatonToken = new AuthenticatonToken(token);
            return authenticatonToken;
        } else if (role == 2)  //Student
        {
                Student student= userDetailService.findStudentByUserName(authRequest.getUserName());
                String token= jwtUtil.generateToken(student);
                AuthenticatonToken authenticatonToken= new AuthenticatonToken(token);
                return authenticatonToken;

        } else {            //Parent
            Parent parent= userDetailService.findParentByUserName(authRequest.getUserName());
            String token= jwtUtil.generateToken(parent);
            AuthenticatonToken authenticatonToken= new AuthenticatonToken(token);
            return authenticatonToken;
        }

    }

    @PostMapping("/account/{accountId}/password/{password}")
    public Account updatePassword( @PathVariable int accountId, @PathVariable String password) {
            return userDetailService.updatePassword(accountId, password);
    }
    @PostMapping("/account/{accountId}/address/{address}/phone/{phone}")
    public Role updateInfo( @PathVariable int accountId, @PathVariable String address, @PathVariable String phone) {
        return userDetailService.updateInfo(accountId, address,phone);
    }

    @GetMapping("/account/phone/{phone}")
    public Role availablePhone(@PathVariable String phone) {
        return userDetailService.phoneAvailable(phone);
    }

    @PostMapping("/account/phone/{uPhone}/password{uPassword}")
    public Account updatePasswordByPhone(String phone, String password){
        return  userDetailService.updatePasswordByPhone(phone, password);
    }
}
