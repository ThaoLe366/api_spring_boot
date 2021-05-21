package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.SchoolTime;
import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.service.SchoolTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class SchoolTimeController {

    @Autowired
    private SchoolTimeService service;

    @PostMapping ("/schooltime")
    public SchoolTime create(@RequestBody SchoolTime schoolTime){
        return service.create(schoolTime);
    }

    @GetMapping ("/schooltime")
    public List<SchoolTime> getAll(){
        return service.findAll();
    }

    @GetMapping("/schooltime/{id}")
    public SchoolTime getById(@PathVariable int id){
        return service.findById(id);
    }

    @DeleteMapping("/schooltime/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

    @GetMapping("/schooltime/start/{id}")
    public String getStartingTime(@PathVariable int id){
        return service.getTimeStart(id);
    }

    @GetMapping("/schooltime/end/{id}")
    public String getEndTime(@PathVariable int id){
        return service.getEndTime(id);
    }

    @PutMapping ("/schooltime")
    public SchoolTime update(@RequestBody SchoolTime schoolTime){
        SchoolTime s = service.findById(schoolTime.getSchoolTimeOrder());
        s.setEndTime(schoolTime.getEndTime());
        s.setStartingTime(schoolTime.getStartingTime());
        return service.create(s);
    }
}
