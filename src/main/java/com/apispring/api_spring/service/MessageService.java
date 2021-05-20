package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Message;
import com.apispring.api_spring.respository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message createMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getMessageBySenderAccountId(int accountId){
        return messageRepository.findMessageBySenderAccountId(accountId);
    }

//    public List<Message> getMessageByTwoAccountId(int senderId, int receiverId){
//        return messageRepository.findMessageByTwoAccountId(senderId, receiverId);
//    }

}
