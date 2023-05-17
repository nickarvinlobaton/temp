package com.example.springenrollment.service;

import com.example.springenrollment.dto.ClassesDto;

import java.util.List;

public interface ClassesService {
    ClassesDto create(ClassesDto classesDto);
    ClassesDto update(ClassesDto classesDto);
    ClassesDto delete(long id);
    ClassesDto find(long id);
    List<ClassesDto> getAll();
}
