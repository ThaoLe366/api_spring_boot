package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OffRequest {

    @Id
    @GeneratedValue
    private int offRequestId;

    @NonNull
    @Column(name = "createTime", insertable = false, updatable = false)
    private Date createTime;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher sender;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class _class;

    public int getOffRequestId() {
        return offRequestId;
    }

    public void setOffRequestId(int offRequestId) {
        this.offRequestId = offRequestId;
    }

    @NonNull
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(@NonNull Date createTime) {
        this.createTime = createTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Teacher getSender() {
        return sender;
    }

    public void setSender(Teacher sender) {
        this.sender = sender;
    }

    public Class get_class() {
        return _class;
    }

    public void set_class(Class _class) {
        this._class = _class;
    }

    public OffRequest() {
    }
}
