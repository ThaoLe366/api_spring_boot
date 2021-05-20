package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.ConfirmationPaper;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.StudentConfirmationpaper;
import com.apispring.api_spring.entity.StudentConfirmpaperId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentConfirmationpaperRepository  extends JpaRepository<StudentConfirmationpaper, StudentConfirmpaperId> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value=" UPDATE confirmation_paper SET  confirmationpaper_name = :name WHERE confirmationpaper_id = :id " , nativeQuery = true)
        //@Query("update Employee c set c.name_employee = hoang where c.id_employee= :id"
    int update(@Param("id") int id, @Param("name") String name);


    List<StudentConfirmationpaper> findByStudent(Student student);

    List<StudentConfirmationpaper> findByConfirmationPaper (ConfirmationPaper confirmationPaper);

}
