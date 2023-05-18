package com.example.springenrollment.service.impl;

import com.example.springenrollment.dto.SubjectDto;
import com.example.springenrollment.entity.Subject;
import com.example.springenrollment.exception.EntityNotFoundException;
import com.example.springenrollment.repository.SubjectRepository;
import com.example.springenrollment.service.SubjectService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private ModelMapper modelMapper;
    private SubjectRepository subjectRepository;

    @Override
    public SubjectDto create(SubjectDto subjectDto) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        Subject savedSubject = subjectRepository.save(subject);

        return modelMapper.map(savedSubject, SubjectDto.class);
    }

    @Override
    public SubjectDto update(SubjectDto subjectDto) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        Subject existingSubject = subjectRepository.findById(subject.getId()).get();
        existingSubject.setName(subject.getName());
        existingSubject.setDescription(subject.getDescription());
        Subject updatedSubject = subjectRepository.save(existingSubject);

        return modelMapper.map(updatedSubject, SubjectDto.class);
    }

    @Override
    public SubjectDto delete(long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (!optionalSubject.isPresent()) {
            throw new EntityNotFoundException("Subject with id: " + id + " not found.");
        }
        subjectRepository.deleteById(id);
        return modelMapper.map(optionalSubject.get(), SubjectDto.class);
    }

    @Override
    public SubjectDto find(long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (!optionalSubject.isPresent()) {
            throw new EntityNotFoundException("Subject with id: " + id + " not found.");
        }

        return modelMapper.map(optionalSubject.get(), SubjectDto.class);
    }

    @Override
    public List<SubjectDto> getAll() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map((subj) -> modelMapper.map(subj, SubjectDto.class)).collect(Collectors.toList());
    }
}
