package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Parent;
import com.apispring.api_spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ParentRepository  extends JpaRepository<Parent, Integer> {
    @Query("select p from Parent p where p.student.studentId = ?1")
    Parent findParentByChildId(String childId);

    @Query("select p from Parent p where p.parentId =?1")
    Parent findById(String idParent);
}
