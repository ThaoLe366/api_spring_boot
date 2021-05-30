package com.apispring.api_spring.service;

import com.apispring.api_spring.dto.AnnounceDTO;
import com.apispring.api_spring.entity.Announcement;
import com.apispring.api_spring.entity.Class;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.mapper.AnnouncementMapper;
import com.apispring.api_spring.respository.AnnouncementRepository;
import com.apispring.api_spring.respository.ClassRepository;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private AnnouncementMapper mapper;

    public AnnounceDTO save (AnnounceDTO announceDTO){

        Announcement announcement= mapper.toEntity(announceDTO);
        return   mapper.toDTO(announcementRepository.save(announcement));
    }

    public List<Announcement> findAll (){
        return  announcementRepository.findAll(Sort.by("announcementTime"));
    }

    public Announcement findById(int id){
        return announcementRepository.findById(id).orElse(null);
    }

    public List<Announcement> findBySenderId(String senderId){

        Teacher teacher= teacherRepository.findById(senderId).orElse(null);
        return announcementRepository.findAnnouncementsBySender(teacher);
    }


    public void deleteById(int id){
        announcementRepository.deleteById(id);
    }

    public List<Announcement> findByClassId(String classId){
        Class _class= classRepository.findById(classId).orElse(null);
        return announcementRepository.findAnnouncementBy_class(_class);
    }

    public List<Announcement> findByStudentId(String studentId){
        return announcementRepository.findAnnouncementByStudentId(studentId);
    }



}
