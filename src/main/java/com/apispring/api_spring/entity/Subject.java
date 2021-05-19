package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @NonNull
    @Column(name = "SubjectId")
    private int subjectId;

    @Column(name = "Name")
    private String name;

    @Column(name = "NumberOfCredit")
    private int numberOfCredit;

    @Column(name = "Description")
    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(int numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject(int subjectId, String name, int numberOfCredit, String description, Collection<Class> classes) {
        this.subjectId = subjectId;
        this.name = name;
        this.numberOfCredit = numberOfCredit;
        this.description = description;
        this.classes = classes;
    }

    public Subject() {
    }
}
