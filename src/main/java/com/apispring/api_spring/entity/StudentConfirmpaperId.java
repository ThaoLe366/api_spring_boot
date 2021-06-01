package com.apispring.api_spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentConfirmpaperId implements Serializable {

    @Column(name = "StudentId")
    private String student;

    @Column(name = "RequiredTime")
    private Date requiredTime;

    @Column(name = "ConfirmationPaperId")
    private int confirmationPaper;


    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getConfirmationPaper() {
        return confirmationPaper;
    }

    public void setConfirmationPaper(int confirmationPaper) {
        this.confirmationPaper = confirmationPaper;
    }

    public Date getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(Date requiredTime) {
        this.requiredTime = requiredTime;
    }
}
