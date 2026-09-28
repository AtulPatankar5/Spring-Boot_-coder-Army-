package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.dto.CreateStudentRequestDto;
import in.strikes.crudSpringBootDemo.dto.CreateStudentResponseDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.exception.DuplicateResourceException;
import in.strikes.crudSpringBootDemo.exception.ResourceNotException;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReq) {

        Student student = mapToEntity(studentReq);
        if (emailExists(student)) {
            throw new DuplicateResourceException("Student with email: " + student.getEmail() + " already exists.");
        }
        Student studentResp = studentRepository.save(student);
        return mapToDto(studentResp);
    }

    public CreateStudentResponseDto getStudent(Long id) {
        Student studentResp = studentRepository.
                findByIdAndIsDeletedIsFalse(id).
                orElseThrow(() ->
                        new ResourceNotException("Student with id: " + id + " not found"));

        return mapToDto(studentResp);

    }

    public List<CreateStudentResponseDto> getAllStudent() {
        List<Student> studentList = studentRepository.findByIsDeletedIsFalse();

        return studentList.stream().map(this::mapToDto).toList();
    }


    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
        Student studentToSave = studentRepository.
                findByIdAndIsDeletedIsFalse(id).
                orElseThrow(() -> new ResourceNotException("Student with id: " + id + "not found"));

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setCreateAt(LocalDateTime.now());
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student studentSaved = studentRepository.save(studentToSave);

        return mapToUpdateDto(studentSaved);
    }

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository.findById(id).
                orElseThrow(() -> new ResourceNotException("Student with id: " + id + "not found"));
        studentRepository.delete(studentToBeDeleted);

    }

    public void softDelete(long id) {
        Student studentToBeDeleted = studentRepository.findByIdAndIsDeletedIsFalse(id).
                orElseThrow(() -> new ResourceNotException("Student with id: " + id + "not found"));
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto) {
        Student student = new Student();
        student.setName((createStudentRequestDto.getName()));
        student.setAge((createStudentRequestDto.getAge()));
        student.setEmail((createStudentRequestDto.getEmail()));
        student.setRollNo((createStudentRequestDto.getRollNo()));
        student.setSubject((createStudentRequestDto.getSubject()));

        student.setDeleted(false);
        student.setCreateAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto createStudentResponseDto = new CreateStudentResponseDto();
        createStudentResponseDto.setId(student.getId());
        createStudentResponseDto.setName((student.getName()));
        createStudentResponseDto.setAge((student.getAge()));
        createStudentResponseDto.setEmail((student.getEmail()));
        createStudentResponseDto.setRollNo((student.getRollNo()));
        createStudentResponseDto.setSubject((student.getSubject()));
        createStudentResponseDto.setMessage("Student saved successfully");
        createStudentResponseDto.setCreateAt(student.getCreateAt());
        createStudentResponseDto.setUpdatedAt(student.getUpdatedAt());
        return createStudentResponseDto;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto updateStudentResponseDto = new UpdateStudentResponseDto();
        updateStudentResponseDto.setId(student.getId());
        updateStudentResponseDto.setName((student.getName()));
        updateStudentResponseDto.setAge((student.getAge()));
        updateStudentResponseDto.setEmail((student.getEmail()));
        updateStudentResponseDto.setRollNo((student.getRollNo()));
        updateStudentResponseDto.setSubject((student.getSubject()));
        updateStudentResponseDto.setMessage("Student saved successfully");
        updateStudentResponseDto.setCreateAt(student.getCreateAt());
        updateStudentResponseDto.setUpdatedAt(student.getUpdatedAt());
        return updateStudentResponseDto;
    }

    private boolean emailExists(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }
}
