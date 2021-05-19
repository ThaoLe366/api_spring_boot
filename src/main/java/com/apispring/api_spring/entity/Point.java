package com.apispring.api_spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "point")
public class Point {

    @Id
    @GeneratedValue
    private float midterm;

    private float finalterm;

    private float total;

    private char grade;

    private boolean ispass;

    private int semester;

    private String year;

    @Column(name = "student_id")
    private int studentId;

    private String subject;

    public Point(float midterm, float finalterm, float total, char grade, boolean ispass, int semester, String year, int idStudent, String subject) {
        this.midterm = midterm;
        this.finalterm = finalterm;
        this.total = total;
        this.grade = grade;
        this.ispass = ispass;
        this.semester = semester;
        this.year = year;
        this.studentId = idStudent;
        this.subject = subject;
    }

    public Point() {

    }

    public float getMidterm() {
        return midterm;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public float getFinalterm() {
        return finalterm;
    }

    public void setFinalterm(float finalterm) {
        this.finalterm = finalterm;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public boolean isIspass() {
        return ispass;
    }

    public void setIspass(boolean ispass) {
        this.ispass = ispass;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getIdStudent() {
        return studentId;
    }

    public void setIdStudent(int idStudent) {
        this.studentId = idStudent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
