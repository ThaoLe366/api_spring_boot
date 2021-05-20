package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.FeeperCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends JpaRepository<FeeperCredit,Integer> {




}
