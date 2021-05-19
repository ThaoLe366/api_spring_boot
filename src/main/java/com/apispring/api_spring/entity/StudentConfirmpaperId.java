package com.apispring.api_spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentConfirmpaperId implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "required_time")
    private Date requiredTime;

    @Column(name = "confirmationPaper_id")
    private int confirmationPaperId;


}
