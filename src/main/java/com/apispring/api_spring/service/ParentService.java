package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Parent;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.ParentRepository;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    private ParentRepository repository;

    public List<Parent> findAll(){return  repository.findAll();}

    public void delete (String parentId){
        repository.deleteById(parentId);
    }

    public Parent createParent(Parent newParent) {

        return repository.save(newParent);
    }

    public Parent getParentById(String idParent) {

        return repository.findById(idParent).orElse(null);
    }

    public Parent updateInfo(@org.jetbrains.annotations.NotNull Parent parent){
        //newStudent.setAccount(newStudent.getAccount());

        Parent oldParent = this.getParentById(parent.getParentId());

        //Update profile
        oldParent.setParentPhone(parent.getParentPhone());
        oldParent.setParentAddress(parent.getParentAddress());

        return repository.save(oldParent);
    }

    public Parent updateDefault(Parent parent){
        Parent oldParent = this.getParentById(parent.getParentId());

        //Update profile
        oldParent.setParentPhone(parent.getParentPhone());
        oldParent.setParentAddress(parent.getParentAddress());
        oldParent.setParentEmail(parent.getParentEmail());
        oldParent.setParentImage(parent.getParentImage());
        oldParent.setParentName(parent.getParentName());
        oldParent.setParentBirthday(parent.getParentBirthday());
        oldParent.setStudent(parent.getStudent());
        //For update password
        Account oldAccount = oldParent.getAccount();
        //Base on way add data
        oldAccount.setPassword(parent.getAccount().getPassword());
        oldParent.setAccount(oldAccount);
       return repository.save(oldParent);
    }
    public Parent getParentByChildrenID(String id){
        return repository.findParentByChildId(id);
    }

    public Parent updatePassword(Parent parent){
        Parent oldParent = this.getParentById(parent.getParentId());
        //For update password
        Account oldAccount = oldParent.getAccount();
        oldAccount.setPassword(parent.getAccount().getPassword());
        oldParent.setAccount(oldAccount);

        return repository.save(oldParent);
    }
}
