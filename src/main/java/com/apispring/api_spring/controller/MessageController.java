package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Message;
import com.apispring.api_spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping ("/message")
    public Message createMessage(@RequestBody Message message){
        message.setSentTime(Calendar.getInstance().getTime());
        return messageService.createMessage(message);
    }


//    @GetMapping("message/{id}")
//    public Message findById(@PathVariable String id){
//        int messageId = Integer.parseInt(id);
//        return messageService.getMessageById(messageId);
//    }


    @GetMapping("/message/sender/{id}")
    public List<Message> getMessageBySenderAccountId(@PathVariable int id){

        return messageService.getMessageBySenderAccountId(id);
    }

    @GetMapping("/message")
    public List<Message> findAll(){
        return messageService.findAll();
    }

}
