package com.apispring.api_spring.entity;
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
    @Column (name = "student_id")
    private String studentId;

    @Column (name = "student_name")
    private String studentName;

    @Column (name = "student_birthday")
    private Date studentBirthday;

    @Column (name = "student_phone")
    private String studentPhone;

    @Column (name = "student_address")
    private String studentAddress;

    @Column (name = "student_email")
    private String studentEmail;

    @Column (name = "student_image")
    private String studentImage;


    @OneToOne
    @JoinColumn (name = "account_id") // foreign key with table Account
    private Account account;

    @OneToMany(mappedBy = "_class")
    private Collection<StudentClass> classes;




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
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public Account getAccountId() {
        return account;
    }

    public void setAccountId(Account account) {
        this.account = account;
    }

    public Student() {
    }
}
