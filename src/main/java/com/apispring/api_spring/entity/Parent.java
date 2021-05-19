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
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue
    @NonNull
    @Column (name = "parent_id")
    private int parentId;

    @Column (name = "parent_name")
    private String parentName;

    @Column (name = "parent_birthday")
    private Date parentBirthday;

    @Column (name = "parent_phone")
    private String parentPhone;

    @Column (name = "parent_address")
    private String parentAddress;

    @Column (name = "parent_email")
    private String parentEmail;

    @Column (name = "parent_image")
    private String parentImage;

    @OneToOne
    @JoinColumn (name = "account_id") // foreign key with table Account
    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getParentBirthday() {
        return parentBirthday;
    }

    public void setParentBirthday(Date parentBirthday) {
        this.parentBirthday = parentBirthday;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getParentAddress() {
        return parentAddress;
    }

    public void setParentAddress(String parentAddress) {
        this.parentAddress = parentAddress;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getParentImage() {
        return parentImage;
    }

    public void setParentImage(String parentImage) {
        this.parentImage = parentImage;
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
