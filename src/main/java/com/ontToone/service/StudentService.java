package com.ontToone.service;

import com.ontToone.dao.StudentRepository;
import com.ontToone.entity.Student;
import com.ontToone.util.Mapper;
import com.ontToone.util.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentDTO addStudentDetails(StudentDTO studentDTO){
        Student student= Mapper.convertStudentDtoToEntity(studentDTO,true);
        studentRepository.save(student);
        return Mapper.convertStudentEntityToDto(student,true);
    }

    public StudentDTO getStudentById(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid student id"));
        return Mapper.convertStudentEntityToDto(student,true);
    }
}
