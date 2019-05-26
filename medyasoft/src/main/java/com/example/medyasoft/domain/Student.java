package com.example.medyasoft.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "number", nullable = false)
    private Integer number;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<StudentLesson> studentLessons = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<StudentLesson> getStudentLessons() {
        return studentLessons;
    }

    public void setStudentLessons(Set<StudentLesson> studentLessons) {
        this.studentLessons = studentLessons;
    }
}
