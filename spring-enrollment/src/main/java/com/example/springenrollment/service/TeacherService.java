package com.example.springenrollment.service;

import com.example.springenrollment.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto create(TeacherDto teacherDto);
    TeacherDto update(TeacherDto teacherDto);
    TeacherDto delete(long id);
    TeacherDto find(long id);
    List<TeacherDto> getAll();
}
