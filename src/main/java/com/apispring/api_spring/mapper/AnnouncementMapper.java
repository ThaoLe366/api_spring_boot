package com.apispring.api_spring.mapper;

import com.apispring.api_spring.dto.AnnounceDTO;
import com.apispring.api_spring.entity.Announcement;
import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.AnnouncementRepository;
import com.apispring.api_spring.respository.ClassRepository;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class AnnouncementMapper {

    @Autowired
    private ClassRepository cRepository;

    @Autowired
    private TeacherRepository tRepository;

    public Announcement toEntity(AnnounceDTO announceDTO){

        Announcement announcement= new Announcement();

        announcement.setAnnouncementID(announceDTO.getAnnouncementID());
        announcement.set_Class(new Class(announceDTO.get_ClassId()));
        announcement.setAnnouncementTime(announceDTO.getAnnouncementTime());
        announcement.setContent(announceDTO.getContent());
        announcement.setSender(new Teacher(announceDTO.getSenderId()));

        return announcement;
    }

    public AnnounceDTO toDTO (Announcement announcement){
        AnnounceDTO announceDTO= new AnnounceDTO();

        announceDTO.setAnnouncementID(announcement.getAnnouncementID());
        announceDTO.set_ClassId(announcement.get_Class().getClassId());
        announceDTO.setAnnouncementTime(announcement.getAnnouncementTime());
        announceDTO.setSenderId(announcement.getSender().getTeacherID());
        announceDTO.setContent(announcement.getContent());

        return announceDTO;
    }

}
