package com.example.medyasoft.service;

import com.example.medyasoft.domain.Lesson;
import com.example.medyasoft.domain.Student;
import com.example.medyasoft.domain.StudentLesson;
import com.example.medyasoft.domain.dto.StudentLessonDto;
import com.example.medyasoft.repository.LessonRepository;
import com.example.medyasoft.repository.StudentLessonRepository;
import com.example.medyasoft.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentLessonService {
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;
    private final StudentLessonRepository studentLessonRepository;

    public StudentLessonService(LessonRepository lessonRepository, StudentRepository studentRepository, StudentLessonRepository studentLessonRepository) {
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
        this.studentLessonRepository = studentLessonRepository;
    }

    public Page<Lesson> findAllLessons(int pageNumber, int pageSize) {
        Page<Lesson> lessonList = lessonRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return lessonList;
    }
    public Page<Student> findAllStudents(int pageNumber, int pageSize) {
        Page<Student> studentList = studentRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return studentList;
    }
    public Page<Student> additiveStudentsList(Long lessonId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Student> listStudent = studentRepository.findByStudentLessonsLessonId(lessonId);
        List<Student> allStudentsList = studentRepository.findAll();
        allStudentsList.removeAll(listStudent);

        int max = (pageSize *(pageNumber + 1) > allStudentsList.size())? allStudentsList.size(): pageSize *(pageNumber+1);
        Page<Student> pageStudentsList = new PageImpl<Student>(allStudentsList.subList(pageNumber * pageSize, max), pageable, allStudentsList.size());
        return pageStudentsList;
    }
    public void addStudentToLesson(StudentLessonDto studentLessonDto) {
        Optional<Student> student = studentRepository.findById(studentLessonDto.getStudentId());
        Optional<Lesson> lesson = lessonRepository.findById(studentLessonDto.getLessonId());
        StudentLesson studentLesson = new StudentLesson();
        studentLesson.setLesson(lesson.get());
        studentLesson.setStudent(student.get());
        studentLessonRepository.save(studentLesson);
    }
    public Page<Student> getRegisteredStudentsForLesson(Long lessonId, int pageNumber, int pageSize) {
        Page<Student> registeredStudentList = studentRepository.findByStudentLessonsLessonId(lessonId, PageRequest.of(pageNumber, pageSize));
        return registeredStudentList;
    }

}
