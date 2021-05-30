package com.apispring.api_spring.respository;


import com.apispring.api_spring.entity.OffRequest;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffRequestRepository extends JpaRepository<OffRequest,Integer> {

    public List<OffRequest> findOffRequestBySender(Teacher sender);

    public void deleteAllBySender(Teacher sender);

}
