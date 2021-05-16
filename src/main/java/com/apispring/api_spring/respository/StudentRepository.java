package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository   extends JpaRepository<Student, Integer> {

}
