package com.apispring.api_spring.service;


import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.StudentRepository;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    public Student createStudent(Student newStudent) {

        return repository.save(newStudent);
    }

    public Student getStudentById(int idStudent) {

        return repository.findById(idStudent).orElse(null);
    }
}
