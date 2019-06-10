package com.example.medyasoft.repository;

import com.example.medyasoft.domain.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository <Lesson, Long> {

}
