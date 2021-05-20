package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ClassRepository extends JpaRepository<Class,Integer> {
    @Query("select c from Class c where c.classId =?1")
    Class findByIdSubject(String id);
}
