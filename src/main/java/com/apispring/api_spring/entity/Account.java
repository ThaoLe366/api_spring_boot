package com.apispring.api_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT_TBL")
public class Account {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO
    )
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "username")
    private String username;

    @Column (name = "password")
    private String password;

    @OneToMany(mappedBy = "senderAccount")
    private Collection<Message> messageCollection;

    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public  Account(){}

}
