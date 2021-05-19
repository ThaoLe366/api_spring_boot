package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_class")
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

    @Column (name = "middle_mark")
    private float middleMark;

    @Column (name = "final_mark")
    private float finalMark;

    @Column (name = "rating")
    private int rating;

    @Column (name = "comment")
    private String comment;

    @Column (name = "create_date")
    private Date createDate;



    public StudentClass() {
    }
}
