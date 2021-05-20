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
    private Date requiredTime;

    @ManyToOne
    @MapsId("student")       //foreign key with table Student
    private Student student;

    //foreign key with table ConfirmationPaper
    @ManyToOne
    @MapsId("confirmationPaper")
    private ConfirmationPaper confirmationPaper;

    @NonNull
    public Date getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(@NonNull Date requiredTime) {
        this.requiredTime = requiredTime;
    }

    public StudentConfirmpaperId getStudentConfirmpaperId() {
        return studentConfirmpaperId;
    }

    public void setStudentConfirmpaperId(StudentConfirmpaperId studentConfirmpaperId) {
        this.studentConfirmpaperId = studentConfirmpaperId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ConfirmationPaper getConfirmationPaper() {
        return confirmationPaper;
    }

    public void setConfirmationPaper(ConfirmationPaper confirmationPaper) {
        this.confirmationPaper = confirmationPaper;
    }

    public StudentConfirmationpaper() {
    }
}
