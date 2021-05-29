package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.StudentClass;
import com.apispring.api_spring.entity.StudentClassId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentClassRepository extends JpaRepository<StudentClass, StudentClassId> {


    @Query (value = "select s from StudentClass s where s.studentClassId.studentId = :studentId and s.studentClassId.classId = :classId")
    StudentClass findStudentClass(@Param("studentId") String studentId,@Param("classId") String classId);

    @Modifying
    @Query(value = "delete from StudentClass s where s.studentClassId.studentId = :id")
    void deleteByIdStudent(@Param("id") String idStudent);

    @Modifying
    @Query(value = "delete from StudentClass s where s.studentClassId.classId = :id")
    void deleteByIdClass(@Param("id") String idClass);

    @Modifying
    @Query(value = "delete from StudentClass s where s.studentClassId.classId = :id" +
            " and s.studentClassId.studentId = :idS")
    void deleteByIdStudentAndIdClass(@Param("idS") String idStudent, @Param("id") String idClass);


    @Query (value = "select s._class from StudentClass s where s.studentClassId.studentId = :studentId")
    List<Class> findClassByIdStudent(@Param("studentId") String idStudent);

    @Query (value = "select s from StudentClass s where s.studentClassId.studentId = :studentId")
    List<StudentClass> findStudentClassByIdStudent(@Param("studentId") String idStudent);


    @Query (value = "select s from StudentClass s where s.studentClassId.classId = :id")
    List<StudentClass> findStudentClassByIdClass(@Param("id") String idClass);


    @Query (value = "select s._class from StudentClass s where s.studentClassId.studentId = :studentId " +
            " and s._class.semester = :semester and s._class.studyingYear = :year")
    List<Class> getSchedule(@Param("studentId") String studentId, @Param("year") int year, @Param("semester") int semester);

  //  @Query (value = "select s._class from StudentClass s where s.studentClassId.studentId = :studentId")
    @Query(value = "select  s.student from StudentClass  s where  s._class.classId = (:classId)")
    List<Student> findStudentInClass(@Param("classId") String classId);

    @Query (value = "select s from StudentClass s where s.studentClassId.studentId = :studentId " +
            " and s._class.semester = :semester and s._class.studyingYear = :year")
    List<StudentClass> getStudentClassSchedule(@Param("studentId") String studentId, @Param("year") int year, @Param("semester") int semester);

    @Query (value = "select s from StudentClass s where s.studentClassId.studentId = :studentId " +
            " and s._class.semester = :semester and s._class.studyingYear = :year")
    List<StudentClass> findByStudentIdAndYearAndSemester(@Param("studentId") String studentId, @Param("year") int year, @Param("semester") int semester);
}
