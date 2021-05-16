package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
