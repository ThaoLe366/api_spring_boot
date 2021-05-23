package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepository extends JpaRepository<Subject, String> {

    @Query("select s from Subject s where s.subjectId =?1")
    Subject findByIdSubject(String id);


}
