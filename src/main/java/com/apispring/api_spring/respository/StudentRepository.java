package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository   extends JpaRepository<Student, String> {

    public Optional<Student> findById(String studentId);

    public Student findStudentByAccount_Username(String userName);

    public Student findStudentByAccount_AccountId(int accoundId);


    @Query("select s from Student s where s.phone= ?1")
    public Teacher findStudentByPhone(String phone);
}
