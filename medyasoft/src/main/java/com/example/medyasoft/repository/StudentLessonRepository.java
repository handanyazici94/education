package com.example.medyasoft.repository;

import com.example.medyasoft.domain.StudentLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentLessonRepository extends JpaRepository<StudentLesson, Long> {
}


