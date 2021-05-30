package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Announcement;
import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnouncementRepository  extends JpaRepository<Announcement, Integer> {

    public List<Announcement> findAnnouncementsBySender(Teacher teacher);

    public List<Announcement> findAnnouncementBy_class(Class _class);

    @Query( value = "select a from  Announcement a,StudentClass s  where a._class.classId = s.studentClassId.classId and s.studentClassId.studentId= (:studentId)")
    public List<Announcement> findAnnouncementByStudentId(@Param("studentId") String studentId);

}
