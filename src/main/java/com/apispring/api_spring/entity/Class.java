package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "class_id")
    private int classId;

    //@Column (name = "subject_id") // foreign key
    //private int subjectId;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    //@Column (name = "teacher_id") // foreign key
   // private int teacherId;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @Column (name = "semester")
    private int semester;

    @Column (name = "studyingYear")
    private int studyingYear;

    @Column (name = "classStartDate")
    private Date classStartDate;

    @Column (name = "classEndDate")
    private Date classEndDate;

    @Column (name = "classDayOfWeek")
    private int classDayOfWeek;

    @Column (name = "classRoom")
    private String classRoom;

    @Column (name = "startSchoolTime") ///Tiết học
    private int startSchoolTime;

    @Column (name = "endSchoolTime")
    private int endSchoolTime;

    @OneToMany(mappedBy = "_class")
    private Collection<Announcement> announcement;

    @OneToMany(mappedBy = "student")
    private Collection<StudentClass> students;

    public Collection<Announcement> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Collection<Announcement> announcement) {
        this.announcement = announcement;
    }

    public int getClassId() {
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
        this.teacher = teacher;
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
        return classStartDate;
    }

    public void setClassStartDate(Date classStartDate) {
        this.classStartDate = classStartDate;
    }

    public Date getClassEndDate() {
        return classEndDate;
    }

    public void setClassEndDate(Date classEndDate) {
        this.classEndDate = classEndDate;
    }

    public int getClassDayOfWeek() {
        return classDayOfWeek;
    }

    public void setClassDayOfWeek(int classDayOfWeek) {
        this.classDayOfWeek = classDayOfWeek;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getStartSchoolTime() {
        return startSchoolTime;
    }

    public void setStartSchoolTime(int startSchoolTime) {
        this.startSchoolTime = startSchoolTime;
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
        this.classStartDate = temp.getClassStartDate();
        this.classEndDate = temp.getClassEndDate();
        this.classDayOfWeek = temp.getClassDayOfWeek();
        this.startSchoolTime = temp.getStartSchoolTime();
        this.endSchoolTime = temp.getEndSchoolTime();
        this.classRoom = temp.getClassRoom();
    }
}
