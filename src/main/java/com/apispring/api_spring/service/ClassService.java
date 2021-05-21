package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Subject;
import com.apispring.api_spring.respository.ClassRepository;
import com.apispring.api_spring.respository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository repository;

    public Class createClass(Class mClass){
        return   repository.save(mClass);
    }
    public List<Class> findAll (){return repository.findAll();}
    public Class updateClass(Class mClass){
        return repository.save(mClass);
    }
    public Class findClassId(String id){
        return repository.findByIdSubject(id);
    }
    public void delete (String classId){ repository.deleteById(classId);}
}
