package com.apispring.api_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @NonNull
    @Column(name = "SubjectId")
    private String subjectId;

    @Column(name = "Name")
    private String name;

    @Column(name = "NumberOfCredit")
    private int numberOfCredit;

    @Column(name = "Description")
    private String description;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "subject")
    private Collection<Class> classes;

    public Collection<Class> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Class> classes) {
        this.classes = classes;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
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

    public Subject(String  subjectId, String name, int numberOfCredit, String description, Collection<Class> classes) {
        this.subjectId = subjectId;
        this.name = name;
        this.numberOfCredit = numberOfCredit;
        this.description = description;
        this.classes = classes;
    }
    public Subject(String subjectId){
        this.subjectId=subjectId;
    }
    public Subject() {
    }
}
