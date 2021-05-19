package com.apispring.api_spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClassId implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "class_id")
    private int classId;
}

