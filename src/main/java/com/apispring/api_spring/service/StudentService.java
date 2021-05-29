package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> findAll(){ return repository.findAll();}

    public void delete (String studentId){repository.deleteById(studentId);}

    public Student createStudent(Student newStudent) {

        return repository.save(newStudent);
    }

    public Student getStudentById(String idStudent) {

        Optional<Student > student= repository.findById(idStudent);
        if (student.isPresent())
            return student.get();
        return null;
    }

    public Student updateInfo(@org.jetbrains.annotations.NotNull Student student){
        //newStudent.setAccount(newStudent.getAccount());

        Student oldStudent = this.getStudentById(student.getStudentId());

        //Update profile
        oldStudent.setStudentPhone(student.getStudentPhone());
        oldStudent.setStudentAddress(student.getStudentAddress());

        return repository.save(oldStudent);

    }
    public Student updatePassword(Student student){
        Student oldStudent= this.getStudentById(student.getStudentId());

        Account oldAccount= oldStudent.getAccount();
        oldAccount.setPassword(student.getAccount().getPassword());

        oldStudent.setAccount(oldAccount);

        return repository.save(oldStudent);
    }
    public Student updateDefault(Student student){
        Student oldStudent = this.getStudentById(student.getStudentId());

        //Update profile
        oldStudent.setStudentPhone(student.getStudentPhone());
        oldStudent.setStudentAddress(student.getStudentAddress());

        oldStudent.setStudentEmail(student.getStudentEmail());
        oldStudent.setClasses(student.getClasses());
        oldStudent.setStudentImage(student.getStudentImage());
        oldStudent.setStudentName(student.getStudentName());
        oldStudent.setStudentBirthday(student.getStudentBirthday());
        //For update paddword
        Account oldAccount = oldStudent.getAccount();
        oldAccount.setPassword(student.getAccount().getPassword());
        oldStudent.setAccount(oldAccount);

        return  repository.save(oldStudent);
    }


}
