package com.example.sec_spr2.controllers;


import com.example.sec_spr2.models.Student;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/std")
public class StudentController {

    List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> students(){

        if (students.size() <=5){
            students.add(new Student(1L, "nn", "ll"));
            students.add((new Student(2L, "bb", "fdf")));
            students.add(new Student(3L, "n", "l"));
        }

        return students;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        System.out.println(student);
        return student;
    }
}
