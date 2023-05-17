package com.example.springenrollment.service.impl;

import com.example.springenrollment.dto.StudentDto;
import com.example.springenrollment.entity.Student;
import com.example.springenrollment.repository.StudentRepository;
import com.example.springenrollment.repository.UserRepository;
import com.example.springenrollment.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private ModelMapper modelMapper;
    private StudentRepository studentRepository;
    private UserRepository userRepository;

    @Override
    public StudentDto create(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Student savedStudent = studentRepository.save(student);

        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Student existingStudent = studentRepository.findById(student.getId()).get();
        existingStudent.setYearLevel(student.getYearLevel());
        existingStudent.setProgram(student.getProgram());
        existingStudent.setUser(student.getUser());
        Student updatedStudent = studentRepository.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Override
    public StudentDto delete(long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto find(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student -> modelMapper.map(student, StudentDto.class))).collect(Collectors.toList());
    }
}
