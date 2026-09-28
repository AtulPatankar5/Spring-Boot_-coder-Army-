package org.maverick.controller;

import org.maverick.entity.Student;
import org.maverick.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping("/get-student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Student st = studentService.getStudent(id);
        if (st == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(st);
    }

    @GetMapping("/get-student/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> st = studentService.getAllStudent();
        return ResponseEntity.ok(st);
    }

}
