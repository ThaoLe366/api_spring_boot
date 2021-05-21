package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.SchoolTime;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SchoolTimeRepository extends JpaRepository <SchoolTime, Integer> {

    @Query(value = "select s.startingTime from SchoolTime s where s.schoolTimeOrder = :id")
    String getStartingTime (@Param("id") int id);

    @Query(value = "select s.endTime from SchoolTime s where s.schoolTimeOrder = :id")
    String getEndTime (@Param("id") int id);

    @Query(value = "select s from SchoolTime s where s.schoolTimeOrder = :id")
    SchoolTime findBySchoolTimeOrder (@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "delete from SchoolTime s where s.schoolTimeOrder = :id")
    void deleteById(@Param("id") int id);
}
