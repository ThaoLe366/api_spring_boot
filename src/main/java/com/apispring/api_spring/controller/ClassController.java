package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Subject;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.service.ClassService;
import com.apispring.api_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;

    @Autowired
    TeacherService teacherService;

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

    @PutMapping("class/{classId}/teacher/{teacherId}")
    Class assignClassToTeacher(
            @PathVariable String classId,
            @PathVariable String teacherId
    ) {
        Class mClass= classService.findClassId(classId);
        Teacher mTeacher= teacherService.getTeacherById(teacherId);

        mClass.setTeacher(mTeacher);
        //subject.setTeacher(teacher);
        return classService.updateClass(mClass);
    }


}
