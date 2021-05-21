package com.apispring.api_spring.entity;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor

public class StudentClass {

    //Define foreign key for many to many relationship between class and student
    @EmbeddedId
    private  StudentClassId studentClassId;

    @NonNull
    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @NonNull
    @ManyToOne
    @MapsId("classId")
    private Class _class;

    @Column (name = "MiddleMark")
    private float middleMark;

    @Column (name = "FinalMark")
    private float finalMark;

    @Column (name = "Rating")
    private int rating;

    @Column (name = "Comment")
    private String comment;

    @Column (name = "CreateDate")
    private Date createDate;



    public StudentClass() {
    }

    public StudentClassId getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(StudentClassId studentClassId) {
        this.studentClassId = studentClassId;
    }

    @NonNull
    public Student getStudent() {
        return student;
    }

    public void setStudent(@NonNull Student student) {
        this.student = student;
    }

    @NonNull
    public Class get_class() {
        return _class;
    }

    public void set_class(@NonNull Class _class) {
        this._class = _class;
    }

    public float getMiddleMark() {
        return middleMark;
    }

    public void setMiddleMark(float middleMark) {
        this.middleMark = middleMark;
    }

    public float getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(float finalMark) {
        this.finalMark = finalMark;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
