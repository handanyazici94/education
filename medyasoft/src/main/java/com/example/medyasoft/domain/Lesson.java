package com.example.medyasoft.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private Integer code;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "credit", nullable = false)
    private Integer credit;

    @NotNull
    @Column(name = "hour", nullable = false)
    private Long hour;

    @NotNull
    @Column(name = "instructor", nullable = false)
    private String instructor;

    @OneToMany(mappedBy = "lesson" , fetch = FetchType.EAGER)
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<StudentLesson> studentLessons = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Long getHour() {
        return hour;
    }

    public void setHour(Long hour) {
        this.hour = hour;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Set<StudentLesson> getStudentLessons() {
        return studentLessons;
    }

    public void setStudentLessons(Set<StudentLesson> studentLessons) {
        this.studentLessons = studentLessons;
    }
}
