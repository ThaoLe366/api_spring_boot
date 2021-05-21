package com.apispring.api_spring.dto;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Teacher;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class AnnounceDTO {

    private int announcementId;
    private String senderId;
    private String content;
    private Date announcementTime;
    private String _classId;

    public String  getSenderId() {
        return senderId;
    }

    public void setSenderId(String sender) {
        this.senderId = sender;
    }

    public String get_ClassId() {
        return _classId;
    }

    public void set_ClassId(String aClass) {
        _classId = aClass;
    }

    public int getAnnouncementID() {
        return announcementId;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementId = announcementID;
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

    public AnnounceDTO() {
    }
}
