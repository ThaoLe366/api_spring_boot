package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT m FROM Message m where m.messageId.senderAccountId = :accountId")
    List<Message> findMessageBySenderAccountId(@Param("accountId") int accountId);


//    @Query(value = "SELECT m FROM Message m WHERE Message.messageId.senderAccountId = :senderAccountId AND Message.messageId.receiverAccountId =:receiverAccountId")
//    List<Message> findMessageByTwoAccountId(@Param("senderAccountId") int senderAccountId, @Param("receiverAccountId") int receiverAccountId);

}