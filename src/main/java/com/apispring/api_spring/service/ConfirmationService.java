package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.ConfirmationPaper;
import com.apispring.api_spring.respository.ConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfirmationService {

    @Autowired
    ConfirmationRepository repository;

    public List<ConfirmationPaper> findAll (){
        return  repository.findAll();
    }

    public ConfirmationPaper findById(Integer Id){

        Optional<ConfirmationPaper> confirmationPaper = repository.findById(Id);
        if(confirmationPaper.isPresent())
            return confirmationPaper.get();
        return null;
    }

    public ConfirmationPaper save(ConfirmationPaper confirmationPaper){
        return repository.save(confirmationPaper);
    }

    public void deleteById (int Id){
        repository.deleteById(Id);
    }

    public int update (ConfirmationPaper confirmationPaper){
        return repository.update(confirmationPaper.getConfirmationPaperId(), confirmationPaper.getConfirmationPaperName());
    }



}
