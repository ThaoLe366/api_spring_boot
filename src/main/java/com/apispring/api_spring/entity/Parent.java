package com.apispring.api_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
@Entity
public class Parent {


//    @GeneratedValue
    @Id
    @NonNull
    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @OneToOne
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @OneToOne
    @JoinColumn(name = "childId")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return name;
    }

    public void setParentName(String parentName) {
        this.name = parentName;
    }

    public Date getParentBirthday() {
        return birthday;
    }

    public void setParentBirthday(Date parentBirthday) {
        this.birthday = parentBirthday;
    }

    public String getParentPhone() {
        return phone;
    }

    public void setParentPhone(String parentPhone) {
        this.phone = parentPhone;
    }

    public String getParentAddress() {
        return address;
    }

    public void setParentAddress(String parentAddress) {
        this.address = parentAddress;
    }

    public String getParentEmail() {
        return email;
    }

    public void setParentEmail(String parentEmail) {
        this.email = parentEmail;
    }

    public String getParentImage() {
        return image;
    }

    public void setParentImage(String parentImage) {
        this.image = parentImage;
    }

    public Account getAccountId() {
        return account;
    }

    public void setAccountId(Account account) {
        this.account = account;
    }

    public Parent() {
    }
}
