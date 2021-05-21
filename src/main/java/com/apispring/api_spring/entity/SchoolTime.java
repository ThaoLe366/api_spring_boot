package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "school_time")
public class SchoolTime {
    @Id
    @NonNull
    @Column(name = "schooltime_order")
    private int schoolTimeOrder;

    @Column (name = "starting_time")
    private String startingTime;

    @Column (name = "end_time")
    private String endTime;

    public int getSchoolTimeOrder() {
        return schoolTimeOrder;
    }

    public void setSchoolTimeOrder(int schoolTimeOrder) {
        this.schoolTimeOrder = schoolTimeOrder;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public SchoolTime() {
    }

}
