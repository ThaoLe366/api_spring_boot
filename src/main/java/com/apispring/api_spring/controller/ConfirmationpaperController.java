package com.apispring.api_spring.controller;

import com.apispring.api_spring.entity.ConfirmationPaper;
import com.apispring.api_spring.entity.Student;
import com.apispring.api_spring.entity.StudentConfirmationpaper;
import com.apispring.api_spring.service.ConfirmationService;
import com.apispring.api_spring.service.StudentConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConfirmationpaperController {

    @Autowired
    ConfirmationService service;

    @Autowired
    StudentConfirmationService service1;

    @PostMapping("/confirmationpaper")
    public ConfirmationPaper save(@RequestBody ConfirmationPaper confirmationPaper)
    {
        return service.save(confirmationPaper);
    }

    @GetMapping("/confirmationpaper")
    public List<ConfirmationPaper> findall()
    {
        return service.findAll();
    }

    @GetMapping("/confirmationpaper/find/{id}")
    public ConfirmationPaper findById(@PathVariable int id)
    {
        return service.findById(id);
    }

    @DeleteMapping("/confirmationpaper/{id}")
    public void delete(@PathVariable int id)
    {
         service.deleteById(id);
    }

    @PostMapping ("/confirmationpaper/update")
    public int update(@RequestBody ConfirmationPaper confirmationPaper)
    {
        return service.update(confirmationPaper);
    }

    //API of student confirmationpaper

    @PostMapping ("/createconfirmationpaper")
    public StudentConfirmationpaper save (@RequestBody StudentConfirmationpaper confirmationpaper){
        return  service1.save(confirmationpaper);
    }

    @GetMapping("/studentconfirmationpaper")
    private List<StudentConfirmationpaper> findAll()
    {
        return service1.findAll();
    }

    /*@GetMapping("/studentconfirmationpaper/{studentid}")
    public List<StudentConfirmationpaper> findByStudentId(@PathVariable String studentid){
        return service1.findByStudentId(studentid);
    }
*/
}
