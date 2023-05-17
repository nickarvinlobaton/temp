package com.example.springenrollment.controller;

import com.example.springenrollment.dto.TeacherDto;
import com.example.springenrollment.entity.Teacher;
import com.example.springenrollment.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAll() {
        List<TeacherDto> teachers = teacherService.getAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherDto> findById(@PathVariable("id") long id) {
        TeacherDto teacher = teacherService.find(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherDto> save(@RequestBody TeacherDto teacherDto) {
        TeacherDto savedTeacher = teacherService.create(teacherDto);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TeacherDto> delete(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(teacherService.delete(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TeacherDto> update(@RequestBody TeacherDto teacherDto) {
        return new ResponseEntity<>(teacherService.update(teacherDto), HttpStatus.OK);
    }
}
