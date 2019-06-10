package com.example.medyasoft.service;

import com.example.medyasoft.domain.Lesson;
import com.example.medyasoft.domain.Student;
import com.example.medyasoft.domain.StudentLesson;
import com.example.medyasoft.domain.dto.StudentLessonDto;
import com.example.medyasoft.repository.LessonRepository;
import com.example.medyasoft.repository.StudentLessonRepository;
import com.example.medyasoft.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<Student> additiveStudentsList(Long lessonId) {
        List<Student> listStudent = studentRepository.findByStudentLessonsLessonId(lessonId);
        List<Student> allStudentsList = studentRepository.findAll();
        allStudentsList.removeAll(listStudent);
        return allStudentsList;
    }
    public void addStudentToLesson(StudentLessonDto studentLessonDto) {
        Optional<Student> student = studentRepository.findById(studentLessonDto.getStudentId());
        Optional<Lesson> lesson = lessonRepository.findById(studentLessonDto.getLessonId());
        StudentLesson studentLesson = new StudentLesson();
        studentLesson.setLesson(lesson.get());
        studentLesson.setStudent(student.get());
        studentLessonRepository.save(studentLesson);
    }
    public List<Student> getRegisteredStudentsForLesson(Long lessonId) {
        List<Student> registeredStudentList = studentRepository.findByStudentLessonsLessonId(lessonId);
        return registeredStudentList;
    }

}
