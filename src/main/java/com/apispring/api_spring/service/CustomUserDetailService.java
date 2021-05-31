package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.*;
import com.apispring.api_spring.respository.AccountRepository;
import com.apispring.api_spring.respository.ParentRepository;
import com.apispring.api_spring.respository.StudentRepository;
import com.apispring.api_spring.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = repository.findByUsername(userName);
        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), new ArrayList<>());
    }

    public Account createUser(Account newAccount) {
        return repository.save(newAccount);
    }

//    public List<Account> getUsers(){
//        return repository.findAll();
//    }

    //    public List<Account> saveUser(List<Account> accounts){
//        return repository.saveAll(accounts);
//    }
//
    public Teacher findTeacherByUserName(String userName) {

        Teacher teacher = teacherRepository.findTeacherByAccount_Username(userName);
        return teacher;
    }

    public Parent findParentByUserName(String userName) {
        Parent parent = parentRepository.findParentByAccount_Username(userName);
        return parent;
    }

    public Student findStudentByUserName(String userName) {
        Student student = studentRepository.findStudentByAccount_Username(userName);
        return student;
    }

    public Account getAccountById(int id) {

        return repository.findById(id).orElse(null);
    }

    public String deleteById(int id) {
        repository.deleteById(id);
        return "product remove: " + id;
    }

    public List<Account> findAll() {
        return repository.findAll();
    }

    public Account updatePassword(int accountId, String password) {

        Account existAccount = repository.findById(accountId).orElse(null);

        existAccount.setPassword(password);
        return repository.save(existAccount);
    }

    public Role updateInfo(int accountId, String address, String phone) {

        int role = -1;
        if (teacherRepository.findTeacherByAccount_AccountId(accountId) != null) {
            role = 1;
            Teacher teacher = teacherRepository.findTeacherByAccount_AccountId(accountId);
            teacher.setPhone(phone);
            teacher.setAddress(address);

        } else if (studentRepository.findStudentByAccount_AccountId(accountId) != null) {
            role = 2;
            Student student = studentRepository.findStudentByAccount_AccountId(accountId);
            student.setStudentPhone(phone);
            student.setStudentAddress(address);
        } else if ((parentRepository.findParentByAccount_AccountId(accountId)) != null) {
            role = 3;
            Parent parent = parentRepository.findParentByAccount_AccountId(accountId);
            parent.setParentAddress(address);
            parent.setParentPhone(phone);

        }
        Role r = new Role(role);
        return r;
    }

    public Role phoneAvailable(String phone) {

        int role = -1;
        if (teacherRepository.findTeacherByPhone(phone) != null) {
            role = 1;
        } else if (studentRepository.findStudentByPhone(phone) != null) {
            role = 2;
        } else if (parentRepository.findParentByPhone(phone) != null) {
            role = 3;
        }
        Role r = new Role(role);
        return r;
    }

    public Account updatePasswordByPhone(String phone, String password) {
        Account newAccount= new Account();
        int role = -1;
        if (teacherRepository.findTeacherByPhone(phone) != null) {
            Teacher teacher = teacherRepository.findTeacherByPhone(phone);
            Account oldAccount = teacher.getAccount();
            oldAccount.setPassword(password);
            newAccount = repository.save(oldAccount);
            role = 1;
        } else if (studentRepository.findStudentByPhone(phone) != null) {
            Student student = studentRepository.findStudentByPhone(phone);
            Account oldAccount = student.getAccount();
            oldAccount.setPassword(password);
            newAccount = repository.save(oldAccount);
            role = 2;
        } else if (parentRepository.findParentByPhone(phone) != null) {
            Parent parent = parentRepository.findParentByPhone(phone);
            Account oldAccount = parent.getAccount();
            oldAccount.setPassword(password);
            newAccount = repository.save(oldAccount);
            role = 3;
        }
        return newAccount;
    }

}
