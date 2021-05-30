package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.respository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentClassService {

    @Autowired
    private StudentClassRepository studentClassRepository;

    public StudentClass save(StudentClass studentClass){
        return studentClassRepository.save(studentClass);
    }

    public StudentClass update(StudentClass studentClass){

        return studentClassRepository.save(studentClass);
    }

    public StudentClass findStudentClass(String studentId, String classId){
        return studentClassRepository.findStudentClass(studentId, classId);
    }

    @Transactional
    public void deleteByIdStudent(String studentId){
        studentClassRepository.deleteByIdStudent(studentId);
    }

    @Transactional
    public void deleteByIdClass(String classId){
        studentClassRepository.deleteByIdClass(classId);
    }

    @Transactional
    public void deleteByIdStudentClass(String studentId, String classId){
        studentClassRepository.deleteByIdStudentAndIdClass(studentId, classId);
    }

    public List<Class> getSchedule(String studentId, int year, int semester){
        return studentClassRepository.getSchedule(studentId, year, semester);
    }

    public List<Class> findClassByIdStudent(String studentId){
        return studentClassRepository.findClassByIdStudent(studentId);
    }


    public List<StudentClass> findStudentClassByIdStudent(String studentId){
        return studentClassRepository.findStudentClassByIdStudent(studentId);
    }

    public List<StudentClass> findStudentClassByIdClass(String classId){
        return studentClassRepository.findStudentClassByIdClass(classId);
    }

    public List<StudentClass> findAll(){
        return studentClassRepository.findAll();
    }
    public List<Student> findStudentInClass(String classId){
        return studentClassRepository.findStudentInClass(classId);
    }

    public  List<StudentClass> getStudentClassSchedule(String studentId, int year, int semester){
        return studentClassRepository.getStudentClassSchedule(studentId, year, semester);
    }
    public List<StudentClass> findStudentClassByIdStudentAndYearAndSemester(String studentId, int year, int semester){
        return studentClassRepository.findByStudentIdAndYearAndSemester(studentId, year, semester);
    }

    public List<StudentClass> findByTeacherIdAndYearAndSemester(String teacherId, int year, int semester){
        return studentClassRepository.findByTeacherIdAndYearAndSemester(teacherId,year,semester);
    }

    public List<Student> findStudentPass(String teacherId, int year, int semester){
        ArrayList<Student> students = new ArrayList<>();

        List<StudentClass> studentClasses = studentClassRepository.findByTeacherIdAndYearAndSemester(teacherId,year,semester);
        for (StudentClass i:studentClasses  ) {
            if((i.getFinalMark()+i.getMiddleMark())/2>5)
                students.add(i.getStudent());

        }
        if(students!=null)
            return students;
        return null;
    }

    public int findNumberPass(String teacherId, int year, int semester){
        ArrayList<Student> students=new ArrayList<>();

        List<StudentClass> studentClasses = studentClassRepository.findByTeacherIdAndYearAndSemester(teacherId,year,semester);
        for (StudentClass i:studentClasses  ) {
            if((i.getFinalMark()+i.getMiddleMark())/2>5)
                students.add(i.getStudent());

        }
        if(students!=null)
            return students.size();
        return 0;
    }



}
