package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "senttime")
    private Date sentTime;

    // foreign key with table Account
    //@Column (name = "sender_account_id")
    //private int senderAccountId;

    //@ManyToOne
    //@JoinColumn(name = "account_id")
    private int senderAccount;

    // foreign key with table Account
    //@Column (name = "receiver_account_id")
   // private int receiverAccountId;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account receiverAccount;


    @Column (name = "message_content")
    private String messageContent;

    @NonNull
    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(@NonNull Date sentTime) {
        this.sentTime = sentTime;
    }

  /*  public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccountId(Account senderAccount) {
        this.senderAccount = senderAccount;
    }*/

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(int receiverAccountId) {
        this.receiverAccount = receiverAccount;
    }


    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Message() {
    }
}
