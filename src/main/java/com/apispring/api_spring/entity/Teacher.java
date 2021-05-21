package com.apispring.api_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Teacher {

    @Id
    @Column(name = "teacher_id")
    private String teacherId;

    private String name = null;

    private Date birthday = null;

    private String degree = null;

    private String phone = null;

    private String gender = null;

    private String address = null;

    private String email = null;

    private String image = null;

    @OneToOne
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private Collection<Announcement> announcements;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Collection<Class> classes;

    public Collection<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Collection<Announcement> announcements) {
        this.announcements = announcements;
    }

    public String getTeacherID() {

        return teacherId;
    }

    public void setTeacherID(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Teacher() {
    }

    public Teacher(@NonNull String teacherId){
        this.teacherId= teacherId;
    }

}
