package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Subject;
import com.apispring.api_spring.respository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository repository;

    public Subject createSubject(Subject subject){
      return   repository.save(subject);
    }

    public Subject updateSubject(Subject subject){

        return repository.save(subject);
    }
    public Subject findSubjectById(String id){
        return repository.findByIdSubject(id);
    }

    public List<Subject> findAll(){return  repository.findAll();}

    private void delete (String teacherId){
        repository.deleteById(teacherId);
    }

}
