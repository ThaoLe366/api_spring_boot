package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Subject;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query("select t from Teacher t where t.teacherId =?1")
    Teacher findByIdTeacher(String id);

    Teacher findTeacherByAccount_Username(String userName);

    public Teacher findTeacherByAccount_AccountId(int accountId);

    @Query("SELECT t FROM Teacher t, StudentClass s where t.teacherId = s._class.teacher.teacherId " +
            "and s.studentClassId.studentId = :studentid " +
            "and t.name like concat(CONCAT('%', :name), '%')")
    List<Teacher> getAllTeachersByStudentIDWithSimilarName(String studentid, String name);
}
