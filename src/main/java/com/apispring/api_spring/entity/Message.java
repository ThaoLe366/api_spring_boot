package com.apispring.api_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

//    @Id
//    @GeneratedValue
//    @NonNull
//    @Column(name = "sent_Time")
//    private Date sentTime;

    // foreign key with table Account
    //@Column (name = "sender_account_id")
    //private int senderAccountId;

    //@ManyToOne
    //@JoinColumn(name = "account_id")
    ///private int senderAccount;

    // foreign key with table Account
    //@Column (name = "receiver_account_id")
   // private int receiverAccountId;

    @EmbeddedId
    private MessageId messageId;

    @NonNull
    @ManyToOne
    @MapsId("senderAccountId")
    private Account senderAccount;

    @NonNull
    @ManyToOne
    @MapsId ("receiverAccountId")
    private Account receiverAccount;

    @NonNull
    @Column(name = "sent_time", insertable = false, updatable = false)
    private Date sentTime;

    @Column (name = "message_content")
    private String messageContent;

    public MessageId getMessageId() {
        return messageId;
    }

    public void setMessageId(MessageId messageId) {
        this.messageId = messageId;
    }

    @NonNull
    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(@NonNull Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    @NonNull
    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(@NonNull Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

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

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Message() {
    }
}
