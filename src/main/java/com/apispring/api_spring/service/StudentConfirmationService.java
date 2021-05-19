package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.ConfirmationPaper;
import com.apispring.api_spring.entity.StudentConfirmationpaper;
import com.apispring.api_spring.respository.StudentConfirmationpaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentConfirmationService {

    @Autowired
    private StudentConfirmationpaperRepository repository;

    public StudentConfirmationpaper save (StudentConfirmationpaper studentConfirmationpaper)
    {
        return repository.save(studentConfirmationpaper);
    }

    public List<StudentConfirmationpaper> findAll (){
        return  repository.findAll();
    }

    /*public List<StudentConfirmationpaper> findByStudentId( String idStudent){
        return repository.findBystudentIdIn(idStudent);
    }*/

    public List<StudentConfirmationpaper> findByConfirmationpaperId (int confirmationpaperId){
        return  repository.findByConfirmationPaper(confirmationpaperId);
    }



}
