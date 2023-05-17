package com.example.springenrollment.dto;

import com.example.springenrollment.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private long id;
    private String yearLevel;
    private String program;
    private User user;
}
