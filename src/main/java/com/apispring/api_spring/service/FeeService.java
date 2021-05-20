package com.apispring.api_spring.service;

import com.apispring.api_spring.entity.FeeperCredit;
import com.apispring.api_spring.respository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    public FeeperCredit save(FeeperCredit feeperCredit){

        return feeRepository.save(feeperCredit);
    }

    public FeeperCredit findById(int id){
        Optional<FeeperCredit> feeperCredit= feeRepository.findById(id);
        if( feeperCredit.isPresent())
            return feeperCredit.get();
        return null;
    }

    public List<FeeperCredit>  findAll(){
        return feeRepository.findAll();
    }

    public void deleteById(int id){
        feeRepository.deleteById(id);
    }

}
