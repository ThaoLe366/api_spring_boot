package com.apispring.api_spring.service;


import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public Teacher createTeacher(Teacher newTeacher) {

        return repository.save(newTeacher);
    }

    public Teacher getTeacherById(String idTeacher) {

        return repository.findByIdTeacher(idTeacher);
    }
    public Teacher updateDefault(Teacher teacher){
        Teacher oldTeacher = repository.findByIdTeacher(teacher.getTeacherID());

        oldTeacher.setName(teacher.getName());
        oldTeacher.setPhone(teacher.getPhone());
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setBirthday(teacher.getBirthday());

        oldTeacher.setDegree(teacher.getDegree());
        oldTeacher.setGender(teacher.getGender());
        oldTeacher.setImage(teacher.getImage());
        oldTeacher.setEmail(teacher.getEmail());

      return   repository.save(oldTeacher);

    }

    public Teacher updateInfo(Teacher teacher){
        Teacher oldTeacher= repository.findByIdTeacher(teacher.getTeacherID());
        //For update profile
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setPhone(teacher.getPhone());

        return repository.save(oldTeacher);
    }
    public  Teacher updatePassword(Teacher teacher){
        Teacher oldTeacher = repository.findByIdTeacher(teacher.getTeacherID());

        Account oldAccount= oldTeacher.getAccount();
        oldAccount.setPassword(teacher.getAccount().getPassword());

        oldTeacher.setAccount(oldAccount);
        return repository.save(oldTeacher);
    }
    public void delete (String teacherId){
        repository.deleteById(teacherId);
    }

    public List<Teacher> findAll (){ return repository.findAll();}
}
