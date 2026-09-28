package org.maverick._6_dtos.service;

import org.maverick._6_dtos.entity.Student;
import org.maverick._6_dtos.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
