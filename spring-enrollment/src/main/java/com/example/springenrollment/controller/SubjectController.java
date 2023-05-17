package com.example.springenrollment.controller;

import com.example.springenrollment.dto.SubjectDto;
import com.example.springenrollment.entity.Subject;
import com.example.springenrollment.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/subject")
public class SubjectController {

    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
        List<SubjectDto> subjects = subjectService.getAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubjectDto> save(@RequestBody SubjectDto subjectDto) {
        return new ResponseEntity<>(subjectService.create(subjectDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubjectDto> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(subjectService.find(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SubjectDto> delete(@PathVariable("id") long id) {
        return new ResponseEntity<>(subjectService.delete(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SubjectDto> update(@RequestBody SubjectDto subjectDto) {
        return new ResponseEntity<>(subjectService.update(subjectDto), HttpStatus.OK);
    }
}
