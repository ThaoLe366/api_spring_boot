package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class,String> {
    @Query("select c from Class c where c.classId =?1")
    Class findByIdSubject(String id);

    @Query("select c from Class c where c.teacher.teacherId =  (:teacherID)")
    List<Class> findClassByTeacher_TeacherID(String teacherID);
}
