package com.apispring.api_spring.controller;


import com.apispring.api_spring.entity.Announcement;
import com.apispring.api_spring.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnouncementController {

    @Autowired
    private AnnouncementService service;

    @PostMapping("/announcement")
    public Announcement save(@RequestBody Announcement announcement){
        return service.save(announcement);
    }

    @GetMapping("/announcement")
    public List<Announcement> findAll (){
        return service.findAll();
    }

    @GetMapping("/announcement/{id}")
    public Announcement findById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping("/announcement/senderId/{senderId}")
    public List<Announcement> findBySenderId(@PathVariable int senderId){
        return service.findBySenderId(senderId);
    }

    @GetMapping("/announcement/classId/{classId}")
    public List<Announcement> findByClassId(@PathVariable int classId){
        return service.findByClassId(classId);
    }

    @DeleteMapping("/announcement/{id}")
    public void delete (@PathVariable int id){
        service.deleteById(id);
    }

}
