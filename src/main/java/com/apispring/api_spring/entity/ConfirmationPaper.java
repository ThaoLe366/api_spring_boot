package com.apispring.api_spring.entity;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "confirmation_paper")
public class ConfirmationPaper {

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ConfirmationPaperId")
    private int confirmationPaperId;

    @Column (name = "confirmationpaper_name")
    private String confirmationPaperName;

    @OneToMany(mappedBy = "student")
    private Collection<StudentConfirmationpaper> students;

    public int getConfirmationPaperId() {
        return confirmationPaperId;
    }

    public void setConfirmationPaperId(int confirmationPaperId) {
        this.confirmationPaperId = confirmationPaperId;
    }

    public String getConfirmationPaperName() {
        return confirmationPaperName;
    }

    public void setConfirmationPaperName(String confirmationPaperName) {
        this.confirmationPaperName = confirmationPaperName;
    }

    public ConfirmationPaper() {
    }
}
