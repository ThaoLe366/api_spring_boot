package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.entity.StudentClassId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface StudentClassRepository extends JpaRepository<StudentClass, StudentClassId> {


    @Query (value = "select s from StudentClass s where s.studentClassId.studentId = :studentId and s.studentClassId.classId = :classId")
    StudentClass findStudentClass(@Param("studentId") String studentId,@Param("classId") String classId);
}
