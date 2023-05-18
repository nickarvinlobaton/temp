package com.example.springenrollment.service.impl;

import com.example.springenrollment.dto.TeacherDto;
import com.example.springenrollment.entity.Teacher;
import com.example.springenrollment.exception.EntityNotFoundException;
import com.example.springenrollment.repository.TeacherRepository;
import com.example.springenrollment.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private ModelMapper modelMapper;
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto create(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        teacherRepository.save(teacher);

        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public TeacherDto update(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        Teacher existingTeacher = teacherRepository.findById(teacher.getId()).get();
        existingTeacher.setPosition(teacher.getPosition());

        Teacher updatedTeacher = teacherRepository.save(existingTeacher);

        return modelMapper.map(updatedTeacher, TeacherDto.class);
    }

    @Override
    public TeacherDto delete(long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (!optionalTeacher.isPresent()) {
            throw new EntityNotFoundException("Teacher with id: " + id + " not found.");
        }
        teacherRepository.deleteById(id);
        return modelMapper.map(optionalTeacher.get(), TeacherDto.class);
    }

    @Override
    public TeacherDto find(long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (!optionalTeacher.isPresent()) {
            throw new EntityNotFoundException("Teacher with id: " + id + " not found.");
        }
        Teacher teacher = optionalTeacher.get();

        return modelMapper.map(teacher, TeacherDto.class);
    }

    @Override
    public List<TeacherDto> getAll() {
        List<Teacher> teachers = teacherRepository.findAll();

        return teachers.stream().map((teacher -> modelMapper.map(teacher, TeacherDto.class))).collect(Collectors.toList());
    }
}
