package com.example.medyasoft.controller;

import com.example.medyasoft.domain.Lesson;
import com.example.medyasoft.domain.Student;
import com.example.medyasoft.domain.dto.PageableDto;
import com.example.medyasoft.domain.dto.StudentLessonDto;
import com.example.medyasoft.service.StudentLessonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<Lesson>> findAllLessons(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return ResponseEntity.ok(studentLessonService.findAllLessons(pageNumber, pageSize));
    }
    @PostMapping(path = "/all-students")
    @ResponseBody
    public ResponseEntity<Page<Student>> findAllStudents(
            @RequestBody PageableDto pageableDto) {
        return ResponseEntity.ok(studentLessonService.findAllStudents(pageableDto.getPageNumber(), pageableDto.getPageSize()));
    }
    @GetMapping(path = "/additive-students-list")
    @ResponseBody
    public ResponseEntity<Page<Student>> additiveStudentsList(
            @RequestParam Long lessonId,
            @RequestParam int pageNumber,
            @RequestParam int pageSize) {

        return ResponseEntity.ok(studentLessonService.additiveStudentsList(lessonId, pageNumber, pageSize));
    }
    @PostMapping(path = "/add-student-to-lesson")
    @ResponseBody
    public ResponseEntity<Void> addStudentToLesson(
            @RequestBody StudentLessonDto studentLessonDto) {
        studentLessonService.addStudentToLesson(studentLessonDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(path = "/get-registered-students")
    @ResponseBody
    public ResponseEntity<Page<Student>> getRegisteredStudentsForLesson(
            @RequestParam Long lessonId,
            @RequestParam int pageNumber,
            @RequestParam int pageSize) {
        return ResponseEntity.ok(studentLessonService.getRegisteredStudentsForLesson(lessonId, pageNumber, pageSize));
    }

}
