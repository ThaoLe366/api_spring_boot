package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository  extends JpaRepository<Parent, Integer> {
}
