package com.example.springenrollment.service;

import com.example.springenrollment.dto.ClassesDto;
import com.example.springenrollment.dto.StudentDto;

import java.util.List;
import java.util.Set;

public interface ClassesService {
    ClassesDto create(ClassesDto classesDto);
    ClassesDto update(ClassesDto classesDto);
    ClassesDto delete(long id);
    ClassesDto find(long id);
    List<ClassesDto> getAll();
    ClassesDto addStudentToClass(long id, Set<StudentDto> studentDtoSet);
    ClassesDto deleteStudentFromClass(long classId, long studentId);
}
