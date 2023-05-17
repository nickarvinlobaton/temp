package com.example.springenrollment.controller;

import com.example.springenrollment.dto.StudentDto;
import com.example.springenrollment.entity.Student;
import com.example.springenrollment.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.create(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> find(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(studentService.find(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentDto> update(@RequestBody StudentDto student) {
        return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StudentDto> delete(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
    }
}
