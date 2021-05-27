package com.apispring.api_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "class")
public class Class {


    @Id
    @NonNull
    @Column(name = "class_id")
    private String classId;

    //@Column (name = "subject_id") // foreign key
    //private int subjectId;
    @ManyToOne
    @JoinColumn(name = "subjectId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@Getter(onMethod = @__( @JsonIgnore))
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
  //  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Teacher teacher;


    @Column (name = "semester")
    private int semester;

    @Column (name = "studying_year")
    private int studyingYear;

    @Column (name = "starting_date")
    private Date startingDate;

    @Column (name = "endDate")
    private Date endDate;

    @Column (name = "day_of_week")
    private int dayOfWeek;

    @Column (name = "class_room")
    private String classRoom;

    @Column (name = "startSchoolTime") ///Tiết học
    private int startingSchoolTime;

    @Column (name = "endSchoolTime")
    private int endSchoolTime;

    @JsonIgnore
    @OneToMany(mappedBy = "_class")
    private Collection<Announcement> announcement;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Collection<StudentClass> students;


    public Collection<StudentClass> getStudents() {
        return students;
    }

    public void setStudents(Collection<StudentClass> students) {
        this.students = students;


    }

    public Collection<Announcement> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Collection<Announcement> announcement) {
        this.announcement = announcement;
    }

    public void setClassId(String classId){
        this.classId= classId;
    }

    public String getClassId() {
        return classId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher= teacher;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getStudyingYear() {
        return studyingYear;
    }

    public void setStudyingYear(int studyingYear) {
        this.studyingYear = studyingYear;
    }

    public Date getClassStartDate() {
        return startingDate;
    }

    public void setClassStartDate(Date classStartDate) {
        this.startingDate = classStartDate;
    }

    public Date getClassEndDate() {
        return endDate;
    }

    public void setClassEndDate(Date classEndDate) {
        this.endDate = classEndDate;
    }

    public int getClassDayOfWeek() {
        return dayOfWeek;
    }

    public void setClassDayOfWeek(int classDayOfWeek) {
        this.dayOfWeek = classDayOfWeek;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getStartSchoolTime() {
        return startingSchoolTime;
    }

    public void setStartSchoolTime(int startSchoolTime) {
        this.startingSchoolTime = startSchoolTime;
    }

    public int getEndSchoolTime() {
        return endSchoolTime;
    }

    public void setEndSchoolTime(int endSchoolTime) {
        this.endSchoolTime = endSchoolTime;
    }

    public Class() {
    }

    public Class (Class temp){
        this.classId = temp.getClassId();
        this.subject = temp.getSubject();
        this.teacher = temp.getTeacher();
        this.semester = temp.getSemester();
        this.studyingYear = temp.getStudyingYear();
        this.startingDate = temp.getClassStartDate();
        this.endDate = temp.getClassEndDate();
        this.dayOfWeek = temp.getClassDayOfWeek();
        this.startingSchoolTime = temp.getStartSchoolTime();
        this.endSchoolTime = temp.getEndSchoolTime();
        this.classRoom = temp.getClassRoom();
    }

    public Class(@NonNull String classId) {
        this.classId = classId;
    }
}
