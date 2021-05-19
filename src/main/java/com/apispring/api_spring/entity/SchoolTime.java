package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "school_time")
public class SchoolTime {
    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "schooltime_order")
    private int schoolTimeOrder;

    @Column (name = "schooltime_starttime")
    private Time schoolTimeStartTime;

    @Column (name = "schooltime_tndtime")
    private Time schoolTimeEndTime;

    public int getSchoolTimeOrder() {
        return schoolTimeOrder;
    }

    public void setSchoolTimeOrder(int schoolTimeOrder) {
        this.schoolTimeOrder = schoolTimeOrder;
    }

    public Time getSchoolTimeStartTime() {
        return schoolTimeStartTime;
    }

    public void setSchoolTimeStartTime(Time schoolTimeStartTime) {
        this.schoolTimeStartTime = schoolTimeStartTime;
    }

    public Time getSchoolTimeEndTime() {
        return schoolTimeEndTime;
    }

    public void setSchoolTimeEndTime(Time schoolTimeEndTime) {
        this.schoolTimeEndTime = schoolTimeEndTime;
    }

    public SchoolTime() {
    }

}
