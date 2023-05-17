package com.example.springenrollment.service.impl;

import com.example.springenrollment.dto.ClassesDto;
import com.example.springenrollment.entity.Classes;
import com.example.springenrollment.repository.ClassesRepository;
import com.example.springenrollment.service.ClassesService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassesServiceImpl implements ClassesService {

    private ClassesRepository classesRepository;
    private ModelMapper modelMapper;

    @Override
    public ClassesDto create(ClassesDto classesDto) {
        Classes classes = modelMapper.map(classesDto, Classes.class);
        Classes savedClass = classesRepository.save(classes);
        return modelMapper.map(savedClass, ClassesDto.class);
    }

    @Override
    public ClassesDto update(ClassesDto classesDto) {
        Classes classes = modelMapper.map(classesDto, Classes.class);
        Classes existingClasses = classesRepository.findById(classes.getId()).get();
        existingClasses.setTeacher(classes.getTeacher());
        existingClasses.setSubject(classes.getSubject());
        Classes updatedClasses = classesRepository.save(existingClasses);
        return modelMapper.map(updatedClasses, ClassesDto.class);
    }

    @Override
    public ClassesDto delete(long id) {
        Classes classes = classesRepository.findById(id).get();
        classesRepository.deleteById(id);
        return modelMapper.map(classes, ClassesDto.class);
    }

    @Override
    public ClassesDto find(long id) {
        Optional<Classes> optionalClasses = classesRepository.findById(id);
        Classes classes = optionalClasses.get();
        return modelMapper.map(classes, ClassesDto.class);
    }

    @Override
    public List<ClassesDto> getAll() {
        List<Classes> classsesList = classesRepository.findAll();

        return classsesList.stream().map((classes -> modelMapper.map(classes, ClassesDto.class))).collect(Collectors.toList());
    }
}