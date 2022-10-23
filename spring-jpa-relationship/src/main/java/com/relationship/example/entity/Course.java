package com.relationship.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fees;
    @ManyToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Set<Student> students;

}
