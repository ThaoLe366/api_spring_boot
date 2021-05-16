package com.apispring.api_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "PARENT_TBL")
public class Parent {

    @Id
    @GeneratedValue
    private int ParentID;

    private String Name=null;

    private Date Birthday=null;

    private String Phone=null;

    private String Address=null;

    private String Email=null;

    private String Gender=null;

    private String Image=null;

    private int AccountID;
}
