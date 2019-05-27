package com.example.medyasoft.controller;

import com.example.medyasoft.domain.Lesson;
import com.example.medyasoft.domain.Student;
import com.example.medyasoft.domain.dto.StudentLessonDto;
import com.example.medyasoft.service.StudentLessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentLessonController {

    private final StudentLessonService studentLessonService;

    public StudentLessonController(StudentLessonService studentLessonService) {
        this.studentLessonService = studentLessonService;
    }

    @GetMapping(path = "/all-lessons")
    @ResponseBody
    public ResponseEntity<List<Lesson>> findAllLessons() {
        return ResponseEntity.ok(studentLessonService.findAllLessons());
    }
    @GetMapping(path = "/all-students")
    @ResponseBody
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentLessonService.findAllStudents());
    }
    @PostMapping(path = "/additive-students-list")
    @ResponseBody
    public ResponseEntity<List<Student>> additiveStudentsList(
            @RequestParam Long lessonId) {

        return ResponseEntity.ok(studentLessonService.additiveStudentsList(lessonId));
    }
    @PostMapping(path = "/add-student-to-lesson")
    @ResponseBody
    public ResponseEntity<Void> addStudentToLesson(
            @RequestBody StudentLessonDto studentLessonDto) {
        studentLessonService.addStudentToLesson(studentLessonDto);
        return ResponseEntity.ok().build();
    }
    @PostMapping(path = "/get-registered-students")
    @ResponseBody
    public ResponseEntity<List<Student>> getRegisteredStudentsForLesson(
            @RequestParam Long lessonId) {
        return ResponseEntity.ok(studentLessonService.getRegisteredStudentsForLesson(lessonId));
    }

}
