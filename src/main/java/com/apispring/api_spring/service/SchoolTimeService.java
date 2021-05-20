package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.SchoolTime;
import com.apispring.api_spring.respository.SchoolTimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolTimeService {

    private SchoolTimeRepository repository;

    public List<SchoolTime> findAll(){
        return repository.findAll();
    }

    public SchoolTime findById(int id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(int id){
        repository.deleteById(id);
    }

    public  SchoolTime createNew(SchoolTime schoolTime){
        return  repository.save(schoolTime);
    }


}
