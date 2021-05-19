package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @NonNull
    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_nocredit")
    private int subjectNoCredit;

    @Column(name = "subject_description")
    private String subjectDescription;

    @OneToMany(mappedBy = "subject")
    private Collection<Class> classes;

    public Collection<Class> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Class> classes) {
        this.classes = classes;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectNoCredit() {
        return subjectNoCredit;
    }

    public void setSubjectNoCredit(int subjectNoCredit) {
        this.subjectNoCredit = subjectNoCredit;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public Subject(String subjectName, int subjectNoCredit, String subjectDescription) {
        this.subjectName = subjectName;
        this.subjectNoCredit = subjectNoCredit;
        this.subjectDescription = subjectDescription;
    }

    public Subject() {
    }
}
