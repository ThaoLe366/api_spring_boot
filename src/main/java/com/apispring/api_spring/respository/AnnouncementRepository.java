package com.apispring.api_spring.respository;

import com.apispring.api_spring.entity.Announcement;
import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository  extends JpaRepository<Announcement, Integer> {

    public List<Announcement> findAnnouncementsBySender(Teacher teacher);

    public List<Announcement> findAnnouncementBy_class(Class _class);

}
