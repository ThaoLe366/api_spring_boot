package com.apispring.api_spring.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_TBL")
public class Student {

    @Id
    @GeneratedValue
    private int StudentID;

    private String Name=null;

    private Date Birthday=null;

    private String Gender=null;

    private String Phone=null;

    private String Address=null;

    private String Email=null;

    private String Image=null;

    private String BankSeri=null;

    private int AccountID;


}
