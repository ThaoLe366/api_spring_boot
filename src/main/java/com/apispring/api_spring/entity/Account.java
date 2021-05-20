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
    private int accountId;

    @Column(name = "username")
    private String username;

    @Column (name = "password")
    private String password;

    @OneToMany(mappedBy = "senderAccount")
    private Collection<Message> messageCollectionSend;


    @OneToMany(mappedBy = "receiverAccount")
    private Collection<Message> messageCollectionReceive;


    public Collection<Message> getMessageCollectionSend() {
        return messageCollectionSend;
    }

    public void setMessageCollectionSend(Collection<Message> messageCollectionSend) {
        this.messageCollectionSend = messageCollectionSend;
    }


    public Collection<Message> getMessageCollectionReceive() {
        return messageCollectionReceive;
    }

    public void setMessageCollectionReceive(Collection<Message> messageCollectionReceive) {
        this.messageCollectionReceive = messageCollectionReceive;
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
