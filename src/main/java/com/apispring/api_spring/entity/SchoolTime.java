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

    @Column (name = "starting_time")
    private Time startingTime;

    @Column (name = "end_time")
    private Time endTime;

    public int getSchoolTimeOrder() {
        return schoolTimeOrder;
    }

    public void setSchoolTimeOrder(int schoolTimeOrder) {
        this.schoolTimeOrder = schoolTimeOrder;
    }

    public Time getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Time startingTime) {
        this.startingTime = startingTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public SchoolTime() {
    }

}
