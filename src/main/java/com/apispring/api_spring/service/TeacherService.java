package com.apispring.api_spring.service;


import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.entity.Teacher;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public Teacher createTeacher(Teacher newTeacher) {

        return repository.save(newTeacher);
    }

    public Teacher getTeacherById(String idTeacher) {
<<<<<<< HEAD

        return repository.findByIdTeacher(idTeacher);
    }
    public Teacher updateDefault(Teacher teacher){
        Teacher oldTeacher = repository.findByIdTeacher(teacher.getTeacherID());

        oldTeacher.setName(teacher.getName());
        oldTeacher.setPhone(teacher.getPhone());
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setBirthday(teacher.getBirthday());

        oldTeacher.setDegree(teacher.getDegree());
        oldTeacher.setGender(teacher.getGender());
        oldTeacher.setImage(teacher.getImage());
        oldTeacher.setEmail(teacher.getEmail());

      return   repository.save(oldTeacher);

    }

    public Teacher updateInfo(Teacher teacher){
        Teacher oldTeacher= repository.findByIdTeacher(teacher.getTeacherID());
        //For update profile
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setPhone(teacher.getPhone());

        //For update password
        Account oldAccount= oldTeacher.getAccount();
        oldAccount.setPassword(teacher.getAccount().getPassword());
        oldAccount.setUsername(teacher.getAccount().getUsername());
=======
>>>>>>> 316843c...  add mapper class

        oldTeacher.setAccount(oldAccount);
        return repository.save(oldTeacher);
    }
}
