package com.apispring.api_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private int TeacherID;

    private String Name=null;

    private Date Birthday=null;

    private String Degree=null;

    private String Phone=null;

    private String Gender=null;

    private String Address=null;

    private String Email=null;

    private String Image=null;

    private int AccountID;

}
