package com.example.springenrollment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String schedule;
    private String time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "student_classes",
            joinColumns = @JoinColumn(name = "classes_id", referencedColumnName = "id", table = "classes"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id", table = "students")
    )
    private Set<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

}
