package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Subject;
import com.apispring.api_spring.respository.ClassRepository;
import com.apispring.api_spring.respository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static com.apispring.api_spring.util.GenerateID.alphaNumericString;

@Service
public class ClassService {
    @Autowired
    ClassRepository repository;

    public Class createClass(Class mClass){
        mClass.setClassId(alphaNumericString(8));
        return   repository.save(mClass);
    }
    public List<Class> findAll (){return repository.findAll();}
    public Class updateClass(Class mClass){
        return repository.save(mClass);
    }
    public Class findClassId(String id){
        return repository.findByIdSubject(id);
    }
    public void delete (String classId){ repository.deleteById(classId);}

    public List<Class> findClassByTeacherId(String teacherId){
        return repository.findClassByTeacher_TeacherID(teacherId);
    }

    public List<Class> findClassesByStudentId(String studentId){
        return repository.findClassesByStudentId(studentId);
    }


}
