package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String userName);



}
