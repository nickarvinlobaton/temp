package com.example.springenrollment.service;

import com.example.springenrollment.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto create(StudentDto studentDto);
    StudentDto update(StudentDto studentDto);
    StudentDto delete(long id);
    StudentDto find(long id);
    List<StudentDto> getAll();
}
