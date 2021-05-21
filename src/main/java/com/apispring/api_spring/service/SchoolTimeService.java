package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.SchoolTime;
import com.apispring.api_spring.respository.SchoolTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolTimeService {

    @Autowired
    private SchoolTimeRepository repository;

    public List<SchoolTime> findAll(){
        return repository.findAll();
    }

    public SchoolTime findById(int id){
        return repository.findBySchoolTimeOrder(id);
    }

    @Transactional
    public void deleteById(int id){
        repository.deleteById(id);
    }

    public  SchoolTime create(SchoolTime schoolTime){
        return  repository.save(schoolTime);
    }

    public String getTimeStart(int id){
       return repository.getStartingTime(id);
    }

    public String getEndTime(int id){
        return repository.getEndTime(id);
    }


}
