package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Subject;
import com.apispring.api_spring.service.ClassService;
import com.apispring.api_spring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    ClassService classService;

    final  String  MainDomain="/subject";
    @PostMapping(MainDomain)
    public Subject createSubject(@RequestBody Subject subject){
       return subjectService.createSubject(subject);
    }

    @GetMapping(MainDomain+"/{subjectId}")
    public Subject getSubject(@PathVariable String subjectId){
       return subjectService.findSubjectById(subjectId);
    }

    @PutMapping(MainDomain)
    public Subject updateSubject(@RequestBody Subject subject){

        Subject oldSubject = subjectService.findSubjectById(subject.getSubjectId());
        oldSubject.setDescription(subject.getDescription());
        oldSubject.setName(subject.getName());
        oldSubject.setNumberOfCredit(subject.getNumberOfCredit());
        return subjectService.updateSubject(oldSubject);
    }
    @PutMapping(MainDomain+"/{subjectId}/classId/{classId}")
    Class assignSubjectToClass(
            @PathVariable String classId,
            @PathVariable String subjectId
    ) {
        Class mClass= classService.findClassId(classId);
        Subject mSubject= subjectService.findSubjectById(subjectId);

        mClass.setSubject(mSubject);
        //subject.setTeacher(teacher);
        return classService.updateClass(mClass);
    }

}
