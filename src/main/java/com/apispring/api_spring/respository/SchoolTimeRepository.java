package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.SchoolTime;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolTimeRepository extends JpaRepository<SchoolTime, Integer> {


}
