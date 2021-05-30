package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.entity.StudentClassId;
import com.apispring.api_spring.service.ClassService;
import com.apispring.api_spring.service.StudentClassService;
import com.apispring.api_spring.service.StudentService;
import com.apispring.api_spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class StudentClassController {

    final String MAPPING = "/student_class";
    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService ;

    @Autowired
    private StudentClassService studentClassService;


    @PostMapping(MAPPING)
    public StudentClass create(@RequestBody StudentClass studentClass){
        studentClass.setRating(0); // rating == 0 => statusRate = not yet
        return studentClassService.save(studentClass);
    }

    @GetMapping(MAPPING)
    public List<StudentClass> findAll(){
        return studentClassService.findAll();
    }

    @PutMapping(MAPPING + "/student/{id_student}/class/{id_class}")
    public StudentClass update(@RequestBody StudentClass studentClass,@PathVariable String id_student, @PathVariable String id_class){
        //update rating and comment
        StudentClass newStudentClass = studentClassService.findStudentClass(id_student, id_class);
        newStudentClass.setComment(studentClass.getComment());
        newStudentClass.setRating(studentClass.getRating());
        newStudentClass.setCreateDate(Calendar.getInstance().getTime());
        return studentClassService.save(newStudentClass);
    }


    @PutMapping (MAPPING)
    public StudentClass update(@RequestBody StudentClass studentClass){
        StudentClass s = studentClassService.findStudentClass(studentClass.getStudentClassId().getStudentId(), studentClass.getStudentClassId().getClassId());
        s.setComment(studentClass.getComment());
        s.setRating(studentClass.getRating());
        s.setCreateDate(Calendar.getInstance().getTime());
        return studentClassService.update(s);
    }

    @GetMapping(MAPPING + "/{id_student}/{id_class}")
    public StudentClass findStudentClass(@PathVariable String id_student, @PathVariable String id_class){
        return studentClassService.findStudentClass(id_student, id_class);
    }

    @GetMapping(MAPPING + "/student/{id_student}")
    public List<StudentClass> findStudentClassByIdStudent(@PathVariable String id_student){
        return studentClassService.findStudentClassByIdStudent(id_student);
    }

    @GetMapping(MAPPING + "/class/{id_class}")
    public List<StudentClass> findStudentClassByIdClass(@PathVariable String id_class){
        return studentClassService.findStudentClassByIdClass(id_class);
    }

    @GetMapping(MAPPING + "/schedule/{id_student}/{year}/{semester}") // find class for student studying this year and this semester
    public List<Class> getSchedule(@PathVariable String id_student, @PathVariable int year, @PathVariable int semester){
        return studentClassService.getSchedule(id_student, year, semester);
    }

    @GetMapping(MAPPING + "/schedule/{id_student}") // find all class by id student
    public List<Class> findClassByIdStudent(@PathVariable String id_student){
        return studentClassService.findClassByIdStudent(id_student);
    }

    @DeleteMapping (MAPPING + "/student/{id_student}")
    public void deleteAllByIdStudent(@PathVariable String id_student){
        studentClassService.deleteByIdStudent(id_student);
    }

    @DeleteMapping (MAPPING + "/class/{id_class}")
    public void deleteAllByIdClass(@PathVariable String id_class){
        studentClassService.deleteByIdClass(id_class);
    }

    @DeleteMapping (MAPPING + "/{id_student}/{id_class}")
    public void deleteByIdStudentClass(@PathVariable String id_student, String id_class){
        studentClassService.deleteByIdStudentClass(id_student, id_class);
    }

    @PutMapping("class/addstudent/{classId}/{studentId}")
    public StudentClass addStudentToClass (@PathVariable String studentId ,@PathVariable String classId){
        Class mclass= classService.findClassId(classId);
        Student student = studentService.getStudentById(studentId);


        StudentClass studentClass = new StudentClass();
        studentClass.set_class(mclass);
        studentClass.setStudent(student);
        StudentClassId id = new StudentClassId();
        id.setClassId(classId);
        id.setStudentId(studentId);
        studentClass.setStudentClassId(id);
        return studentClassService.save(studentClass);

    }

    @GetMapping("class/student")
    public List<Student> getStudentInClass(String classId){
        return studentClassService.findStudentInClass(classId);
    }

    @GetMapping(MAPPING + "/get/{id_student}/{year}/{semester}")
    public List<StudentClass> getStudentClassSchedule(@PathVariable String id_student, @PathVariable int year, @PathVariable int semester){
        return studentClassService.getStudentClassSchedule(id_student, year, semester);
    }
    @GetMapping(MAPPING + "/{id_student}/{year}/{semester}")
    public List<StudentClass> findByStudentIdAndYearAndSemester(@PathVariable String id_student, @PathVariable int year, @PathVariable int semester){
        return studentClassService.findStudentClassByIdStudentAndYearAndSemester(id_student, year, semester);
    }

}
