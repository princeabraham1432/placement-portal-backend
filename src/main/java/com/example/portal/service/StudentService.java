package com.example.portal.service;

import com.example.portal.dto.StudentRequestDTO;
import com.example.portal.dto.StudentResponseDTO;
import com.example.portal.exception.StudentNotFoundException;
import com.example.portal.model.Student;
import com.example.portal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentResponseDTO createStudent(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());
        student.setCgpa(dto.getCgpa());

        return mapToResponse(repo.save(student));
    }

    public List<StudentResponseDTO> getAllStudents() {
        return repo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Long id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        return mapToResponse(student);
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());
        student.setCgpa(dto.getCgpa());

        return mapToResponse(repo.save(student));
    }

    public void deleteStudent(Long id) {
        if (!repo.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        repo.deleteById(id);
    }

    private StudentResponseDTO mapToResponse(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getDepartment(),
                student.getCgpa()
        );
    }
}
