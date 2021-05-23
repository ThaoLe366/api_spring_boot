package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Subject;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query("select t from Teacher t where t.teacherId =?1")
    Teacher findByIdTeacher(String id);

    Teacher findTeacherByAccount_Username(String userName);

}
