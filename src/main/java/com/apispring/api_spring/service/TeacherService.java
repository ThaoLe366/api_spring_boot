package com.apispring.api_spring.service;


import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;
    public Teacher createTeacher(Teacher newTeacher) {

        return repository.save(newTeacher);
    }

    public Teacher getTeacherById(int idTeacher) {

        return repository.findById(idTeacher).orElse(null);
    }
}
