package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.OffRequest;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.OffRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OffRequestService {

    @Autowired
    private OffRequestRepository repository;

    public OffRequest save(OffRequest offRequest){
        return repository.save(offRequest);
    }

    public List<OffRequest> findAll(){
        return repository.findAll();
    }

    public List<OffRequest> findBySenderId(String teacherId){
        Teacher teacher = new Teacher();
        teacher.setTeacherID(teacherId);
        return repository.findOffRequestBySender(teacher);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void deleteByTeacherId(String teacherId){
        Teacher teacher = new Teacher();
        teacher.setTeacherID(teacherId);
        repository.deleteAllBySender(teacher);
    }

}
