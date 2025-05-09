package com.ontToone.controller;

import com.ontToone.service.StudentService;
import com.ontToone.util.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<?> addStudentDetails(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.addStudentDetails(studentDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
}
