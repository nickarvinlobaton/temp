package com.example.springenrollment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Student student;
}
