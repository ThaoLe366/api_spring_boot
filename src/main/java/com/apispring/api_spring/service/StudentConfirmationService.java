package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.ConfirmationPaper;
import com.apispring.api_spring.entity.StudentConfirmationpaper;
import com.apispring.api_spring.respository.ConfirmationRepository;
import com.apispring.api_spring.respository.StudentConfirmationpaperRepository;
import com.apispring.api_spring.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentConfirmationService {


    @Autowired
    private StudentConfirmationpaperRepository repository;

    @Autowired
    private ConfirmationRepository confirmationRepository;

    @Autowired
    private StudentRepository studentRepository;

    public StudentConfirmationpaper save (StudentConfirmationpaper studentConfirmationpaper)
    {
        return repository.save(studentConfirmationpaper);
    }

    public List<StudentConfirmationpaper> findAll (){
        return  repository.findAll();
    }

    public List<StudentConfirmationpaper> findByStudentId( String idStudent){

        return repository.findByStudent(studentRepository.findById(idStudent).get());
    }

    public List<StudentConfirmationpaper> findByConfirmationpaperConfirmationpaperId (int confirmationpaperId){

        return  repository.findByConfirmationPaper(confirmationRepository.findById(confirmationpaperId).get());
    }



}
