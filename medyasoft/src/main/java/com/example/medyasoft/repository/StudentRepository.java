package com.example.medyasoft.repository;

import com.example.medyasoft.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
    List<Student> findAll();
    List<Student> findByStudentLessonsLessonId(Long lessonId);
}
