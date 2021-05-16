package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.Account;
import com.apispring.api_spring.respository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = repository.findByUserName(userName);
        return new org.springframework.security.core.userdetails.User(account.getUserName(), account.getPassword(), new ArrayList<>());
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
    public Account getAccountById(int id) {

        return repository.findById(id).orElse(null);
    }

    public String deleteById(int id) {
        repository.deleteById(id);
        return "product remove: " + id;
    }

    public Account updateUser(Account account) {
        Account existAccount = repository.findById(account.getId()).orElse(null);

        existAccount.setPassword(account.getPassword());
        existAccount.setUserName(account.getUserName());
        return repository.save(existAccount);
    }
}
