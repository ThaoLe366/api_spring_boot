package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT * FROM Message WHERE Message.senderAccount.accountId = :accountId", nativeQuery = true)
    List<Message> findMessageBySenderAccountId(@Param("accountId") int accountId);


    @Query(value = "SELECT * FROM Message WHERE Message.senderAccount.accountId = :senderAccountId AND Message.receiverAccount.accountId =:receiverAccountId", nativeQuery = true)
    List<Message> findMessageByTwoAccountId(@Param("senderAccountId") int senderAccountId, @Param("receiverAccountId") int receiverAccountId);

}