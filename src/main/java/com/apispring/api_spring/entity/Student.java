package com.apispring.api_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @NonNull
    @Column (name = "StudentId")
    private String studentId;


    @Column(name = "Name")
    private String name;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email")
    private String email;

    @Column(name = "Image")
    private String image;

    @Column(name = "Year")
    private int year;

    @Column(name = "BankSeri")
    private String bankSeri;

    @Column(name = "Major")
    private String major;

    @Column(name = "Status")
    private int status; // status = 1 còn học, status = 0 nghỉ học

    @OneToOne
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "_class")
    private Collection<StudentClass> classes;

    @OneToMany(mappedBy = "confirmationPaper")
    private Collection<StudentConfirmationpaper> confirmationpapers;

    public Collection<StudentClass> getClasses() {
        return classes;
    }

    public void setClasses(Collection<StudentClass> classes) {
        this.classes = classes;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return name;
    }

    public void setStudentName(String studentName) {
        this.name = studentName;
    }

    public Date getStudentBirthday() {
        return birthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.birthday = studentBirthday;
    }

    public String getStudentPhone() {
        return phone;
    }

    public void setStudentPhone(String studentPhone) {
        this.phone = studentPhone;
    }

    public String getStudentAddress() {
        return address;
    }

    public void setStudentAddress(String studentAddress) {
        this.address = studentAddress;
    }

    public String getStudentEmail() {
        return email;
    }

    public void setStudentEmail(String studentEmail) {
        this.email = studentEmail;
    }

    public String getStudentImage() {
        return image;
    }

    public void setStudentImage(String studentImage) {
        this.image = studentImage;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBankSeri() {
        return bankSeri;
    }

    public void setBankSeri(String bankSeri) {
        this.bankSeri = bankSeri;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Student() {
    }
}
