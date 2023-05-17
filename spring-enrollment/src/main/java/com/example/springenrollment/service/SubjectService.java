package com.example.springenrollment.service;

import com.example.springenrollment.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto create(SubjectDto subject);
    SubjectDto update(SubjectDto subject);
    SubjectDto delete(long id);
    SubjectDto find(long id);
    List<SubjectDto> getAll();
}
