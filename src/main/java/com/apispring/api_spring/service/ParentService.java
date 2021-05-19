package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Parent;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.ParentRepository;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {
    @Autowired
    private ParentRepository repository;

    public Parent createParent(Parent newParent) {

        return repository.save(newParent);
    }

    public Parent getParentById(int idParent) {

        return repository.findById(idParent).orElse(null);
    }

    public Parent updateInfo(@org.jetbrains.annotations.NotNull Parent parent){
        return repository.save(parent);
        //newStudent.setAccount(newStudent.getAccount());

        //TODO: Complete when relative done
        //newStudent.setClasses();
    }

    public Parent getParentByChildrenID(int id){
        return repository.findParentByChildId(id);
    }
}
