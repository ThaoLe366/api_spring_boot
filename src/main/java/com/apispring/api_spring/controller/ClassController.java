package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.*;
import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService ;

    @Autowired
    StudentClassService studentClassService;

    @Autowired
    SubjectService subjectService;

    final  String  MainDomain="/class";
    @PostMapping(MainDomain)
    public Class createClass(@RequestBody Class mClass){


        return classService.createClass(mClass);
    }

    @GetMapping(MainDomain+"/findall")
    public List<Class> findAll (){
        return  classService.findAll();
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

    @DeleteMapping("class/{classId}")
    public void delete (@PathVariable String classId){
        classService.delete(classId);
    }

    @GetMapping("class/teacher/{teacherId}")
    public List<Class> getClassOfTeacher(@PathVariable String teacherId){
      return   classService.findClassByTeacherId(teacherId);
    }

    @GetMapping("class/studentId/{studentId}")
    public List<Class> findClassesByStudentId(@PathVariable  String studentId){
        return classService.findClassesByStudentId(studentId);
    }


}
