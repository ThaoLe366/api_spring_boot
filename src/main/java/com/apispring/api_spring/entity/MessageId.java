package com.apispring.api_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MessageId implements Serializable {

    @Column(name = "sender_account_id")
    private int senderAccountId;

    @Column (name = "receiver_account_id")
    private int receiverAccountId;

    @Column (name = "sent_time")
    private Date sentTime;
}
