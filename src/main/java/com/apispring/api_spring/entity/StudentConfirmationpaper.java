package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "student_confirmationpaper")
public class StudentConfirmationpaper {

  
    @EmbeddedId
    private StudentConfirmpaperId studentConfirmpaperId;


    @NonNull
    @Column(name = "RequiredTime" , insertable = false, updatable = false)
   // @JsonSetter("requiredTime")
    private Date requiredTime;

    @ManyToOne
    @MapsId("studentId")
  //  @JsonSetter("student")//foreign key with table Student
    private Student student;

    //foreign key with table ConfirmationPaper
    @ManyToOne
    @MapsId("confirmationPaperId")
   // @JsonSetter("confirmationPaper")
    private ConfirmationPaper confirmationPaper;

    @NonNull
    public Date getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(@NonNull Date requiredTime) {
        studentConfirmpaperId.setRequiredTime(requiredTime);
        this.requiredTime = requiredTime;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        studentConfirmpaperId.setStudent(student.getStudentId());
        this.student = student;
    }

    public ConfirmationPaper getConfirmationPaper() {
        return confirmationPaper;
    }

    public void setConfirmationPaper(ConfirmationPaper confirmationPaper) {
        studentConfirmpaperId.setConfirmationPaper(confirmationPaper.getConfirmationPaperId());
        this.confirmationPaper = confirmationPaper;
    }

    public StudentConfirmationpaper() {
    }
}
