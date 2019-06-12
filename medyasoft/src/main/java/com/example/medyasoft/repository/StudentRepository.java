package com.example.medyasoft.repository;

import com.example.medyasoft.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
    List<Student> findByStudentLessonsLessonId(Long lessonId);
    Page<Student> findByStudentLessonsLessonId(Long lessonId, Pageable pageable);
}
