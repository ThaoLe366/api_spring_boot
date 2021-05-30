package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "announcement")
public class Announcement {

    @GeneratedValue
    @Id
    @NonNull
    @Column(name = "AnnouncementID")
    private int announcementId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher sender;

    @Column (name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column (name = "announcementTime")
    private Date announcementTime;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class _class;

    public Teacher getSender() {
        return sender;
    }

    public void setSender(Teacher sender) {
        this.sender = sender;
    }

    public Class get_Class() {
        return _class;
    }

    public void set_Class(com.apispring.api_spring.entity.Class aClass) {
        _class = aClass;
    }

    public int getAnnouncementID() {
        return announcementId;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementId = announcementID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAnnouncementTime() {
        return announcementTime;
    }

    public void setAnnouncementTime(Date announcementTime) {
        this.announcementTime = announcementTime;
    }

    public Announcement() {
    }
}
