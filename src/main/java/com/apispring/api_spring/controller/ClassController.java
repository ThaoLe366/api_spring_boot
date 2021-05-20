package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;
    final  String  MainDomain="/class";
    @PostMapping(MainDomain)
    public Class createClass(@RequestBody Class mClass){

        return classService.createClass(mClass);
    }

    @GetMapping(MainDomain+"/{classId}")
    public Class getClass(@PathVariable String classId){
        return classService.findClassId(classId);
    }

    @PutMapping(MainDomain)
    public Class updateClass(@RequestBody Class mClass){

        Class oldSubject = classService.findClassId(mClass.getClassId());
        oldSubject.setSemester(mClass.getSemester());
        oldSubject.setStudyingYear(mClass.getStudyingYear());
        oldSubject.setClassStartDate(mClass.getClassStartDate());
        oldSubject.setClassEndDate(mClass.getClassEndDate());
        oldSubject.setClassDayOfWeek(mClass.getClassDayOfWeek());
        oldSubject.setStartSchoolTime(mClass.getStartSchoolTime());
        oldSubject.setEndSchoolTime(mClass.getEndSchoolTime());
        oldSubject.setClassRoom(mClass.getClassRoom());

        return classService.updateClass(oldSubject);
    }




}
