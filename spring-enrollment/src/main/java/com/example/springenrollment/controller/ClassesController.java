package com.example.springenrollment.controller;

import com.example.springenrollment.dto.ClassesDto;
import com.example.springenrollment.dto.StudentDto;
import com.example.springenrollment.service.ClassesService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/classes")
public class ClassesController {

    private ClassesService classesService;

    @GetMapping
    public ResponseEntity<List<ClassesDto>> getAll() {
        return new ResponseEntity<>(classesService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassesDto> save(@RequestBody ClassesDto classesDto) {
        return new ResponseEntity<>(classesService.create(classesDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClassesDto> update(@RequestBody ClassesDto classesDto) {
        return new ResponseEntity<>(classesService.update(classesDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClassesDto> delete(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(classesService.delete(id), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClassesDto> find(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(classesService.find(id), HttpStatus.OK);
    }

    @PostMapping("{id}/students")
    @ResponseStatus(HttpStatus.CREATED)
    public ClassesDto addStudentToClass(@PathVariable(name = "id") long id, @RequestBody Set<StudentDto> studentDtoSet) {
        return classesService.addStudentToClass(id, studentDtoSet);
    }

    @DeleteMapping
    public ClassesDto deleteStudentFromClass(@RequestParam long class_id, @RequestParam long student_id) {
        return classesService.deleteStudentFromClass(class_id, student_id);
    }
}
