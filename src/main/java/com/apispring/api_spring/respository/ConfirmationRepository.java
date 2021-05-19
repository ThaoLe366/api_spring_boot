package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.ConfirmationPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ConfirmationRepository extends JpaRepository<ConfirmationPaper,Integer> {


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value=" UPDATE confirmation_paper SET  confirmationpaper_name = :name WHERE confirmationpaper_id = :id " , nativeQuery = true)
        //@Query("update Employee c set c.name_employee = hoang where c.id_employee= :id"
    int update(@Param("id") int id, @Param("name") String name);


}
