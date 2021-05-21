package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
public class StudentClassController {

    @Autowired
    private StudentClassService studentClassService;

    @PostMapping("/student_class")
    public StudentClass create(@RequestBody StudentClass studentClass){
        return studentClassService.save(studentClass);
    }

    @PutMapping("/student_class/student/{id_student}/class/{id_class}")
    public StudentClass update(@RequestBody StudentClass studentClass,@PathVariable String id_student, @PathVariable String id_class){
        //update rating and comment
        StudentClass newStudentClass = studentClassService.findClass(id_student, id_class);
        newStudentClass.setComment(studentClass.getComment());
        newStudentClass.setRating(studentClass.getRating());
        newStudentClass.setCreateDate(Calendar.getInstance().getTime());
        return studentClassService.save(newStudentClass);
    }


}
