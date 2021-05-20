package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Parent;
import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.respository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentClassService {

    @Autowired
    private StudentClassRepository studentClassRepository;

    public StudentClass save(StudentClass studentClass){
        return studentClassRepository.save(studentClass);
    }

    public StudentClass update(StudentClass studentClass){
        return studentClassRepository.save(studentClass);
    }

    public StudentClass findClass(String studentId, String classId){
        return studentClassRepository.findStudentClass(studentId, classId);
    }

}
