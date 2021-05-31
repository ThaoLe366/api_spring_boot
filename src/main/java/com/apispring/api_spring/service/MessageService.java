package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Message;
import com.apispring.api_spring.entity.Student;
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

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public List<Student> getAllStudentOfTeacherWithSimilarName(String teacherId, String name){
        return messageRepository.getAllStudentOfTeacherWithSimilarName(teacherId, name);
    }

    public List<Student> getAllStudentInClassBySimilarName(String classId, String name){
        return messageRepository.getAllStudentInClassBySimilarName(classId, name);
    }

    public List<Message> getMessageBetweenUsers(int senderAccountID, int receiverAccountID){
        return messageRepository.findMessagesBySenderAccount_AccountIdAndReceiverAccount_AccountId(senderAccountID,receiverAccountID);
    }

    public List<Message> getAllMessageByAccount(int accountid){
        return messageRepository.findMessagesBySenderAccount_AccountIdOrReceiverAccount_AccountId(accountid, accountid);
    }

    public List<Message> getMessageBetweenUsersAccount(int senderAccountID, int receiverAccountID){
        return messageRepository.getMessageBetweenUsersAccount(senderAccountID, receiverAccountID);
    }

}