package com.example.springenrollment.dto;

import com.example.springenrollment.entity.Subject;
import com.example.springenrollment.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassesDto {
    private long id;
    private Subject subject;
    private Teacher teacher;
}
