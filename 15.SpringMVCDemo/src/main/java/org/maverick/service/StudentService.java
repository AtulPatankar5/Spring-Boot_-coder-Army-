package org.maverick.service;

import org.maverick.entity.Student;
import org.maverick.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepo.findById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }


}
