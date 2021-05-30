package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.*;
import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @GetMapping("/teacher")
    public List<Teacher> findAll(){
        return  teacherService.findAll();
    }

    @GetMapping("/teacher/{id}")
    public Teacher getInfo(@PathVariable String id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/teacher/accountId/{accountId}")
    public Teacher getTeacherByAccountID(int accountId){
        return teacherService.getTeacherByAccountID(accountId);
    }

    @PutMapping("/teacher/info")
    public Teacher updateInfo(@RequestBody Teacher teacher) {
        return teacherService.updateInfo(teacher);
    }

    @PutMapping("/teacher/default")
    public Teacher updateDefault(@RequestBody Teacher teacher) {
        return teacherService.updateDefault(teacher);
    }

    @DeleteMapping("/teacher/{teacherId}")
    public void delete(@PathVariable String teacherId){
        teacherService.delete(teacherId);
    }

    @PutMapping("/teacher/password")
    public Teacher updatePassword(@RequestBody Teacher teacher) {
        return teacherService.updatePassword(teacher);
    }

    @GetMapping("/teacher/studentId/{studentId}/teacherName/{name}")
    public List<Teacher> getAllTeachersByStudentIDWithSimilarName(@PathVariable String studentId, @PathVariable String name){
        return teacherService.getAllTeachersByStudentIDWithSimilarName(studentId, name);
    }

}
