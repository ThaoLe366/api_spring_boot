package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class StudentClassController {

    final String MAPPING = "/student_class";

    @Autowired
    private StudentClassService studentClassService;

    @PostMapping(MAPPING)
    public StudentClass create(@RequestBody StudentClass studentClass){
        return studentClassService.save(studentClass);
    }

    @PutMapping(MAPPING + "/student/{id_student}/class/{id_class}")
    public StudentClass update(@RequestBody StudentClass studentClass,@PathVariable String id_student, @PathVariable String id_class){
        //update rating and comment
        StudentClass newStudentClass = studentClassService.findStudentClass(id_student, id_class);
        newStudentClass.setComment(studentClass.getComment());
        newStudentClass.setRating(studentClass.getRating());
        newStudentClass.setCreateDate(Calendar.getInstance().getTime());
        return studentClassService.save(newStudentClass);
    }


    @PutMapping (MAPPING)
    public StudentClass update(@RequestBody StudentClass studentClass){
        StudentClass s = studentClassService.findStudentClass(studentClass.getStudentClassId().getStudentId(), studentClass.getStudentClassId().getClassId());
        s.setComment(studentClass.getComment());
        s.setRating(studentClass.getRating());
        s.setCreateDate(Calendar.getInstance().getTime());
        return studentClassService.update(s);
    }

    @GetMapping(MAPPING + "/{id_student}/{id_class}")
    public StudentClass findStudentClass(@PathVariable String id_student, @PathVariable String id_class){
        return studentClassService.findStudentClass(id_student, id_class);
    }

    @GetMapping(MAPPING + "/student/{id_student}")
    public List<StudentClass> findStudentClassByIdStudent(@PathVariable String id_student){
        return studentClassService.findStudentClassByIdStudent(id_student);
    }

    @GetMapping(MAPPING + "/class/{id_class}")
    public List<StudentClass> findStudentClassByIdClass(@PathVariable String id_class){
        return studentClassService.findStudentClassByIdClass(id_class);
    }

    @GetMapping(MAPPING + "/schedule/{id_student}/{year}/{semester}") // find class for student studying this year and this semester
    public List<Class> getSchedule(@PathVariable String id_student, @PathVariable int year, @PathVariable int semester){
        return studentClassService.getSchedule(id_student, year, semester);
    }

    @GetMapping(MAPPING + "/schedule/{id_student}") // find all class by id student
    public List<Class> findClassByIdStudent(@PathVariable String id_student){
        return studentClassService.findClassByIdStudent(id_student);
    }

    @DeleteMapping (MAPPING + "/student/{id_student}")
    public void deleteAllByIdStudent(@PathVariable String id_student){
        studentClassService.deleteByIdStudent(id_student);
    }

    @DeleteMapping (MAPPING + "/class/{id_class}")
    public void deleteAllByIdClass(@PathVariable String id_class){
        studentClassService.deleteByIdClass(id_class);
    }


}