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

        Parent oldParent = parentService.getParentById(parent.getParentId());

        //Update profile
        oldParent.setParentPhone(parent.getParentPhone());
        oldParent.setParentAddress(parent.getParentAddress());

        //For update password
        Account oldAccount = oldParent.getAccount();
        oldAccount.setPassword(parent.getAccount().getPassword());
        oldParent.setAccount(oldAccount);
        return parentService.updateInfo(oldParent);

    }

    @PutMapping("/parent/default")
    public Parent updateDefault(@RequestBody Parent parent) {
        Parent oldParent = parentService.getParentById(parent.getParentId());

        //Update profile
        oldParent.setParentPhone(parent.getParentPhone());
        oldParent.setParentAddress(parent.getParentAddress());
        oldParent.setParentEmail(parent.getParentEmail());
        oldParent.setParentImage(parent.getParentImage());
        oldParent.setParentName(parent.getParentName());
        oldParent.setParentBirthday(parent.getParentBirthday());
        oldParent.setStudent(parent.getStudent());
        //For update password
        Account oldAccount = oldParent.getAccount();
        //Base on way add data
        oldAccount.setPassword(parent.getAccount().getPassword());
        oldParent.setAccount(oldAccount);

        return parentService.updateInfo(oldParent);

    }
}
