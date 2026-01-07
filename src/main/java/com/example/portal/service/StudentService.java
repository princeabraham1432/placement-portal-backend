package com.example.portal.service;

import com.example.portal.dto.StudentRequestDTO;
import com.example.portal.exception.StudentNotFoundException;
import com.example.portal.model.Student;
import com.example.portal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student saveStudent(StudentRequestDTO request) {
        Student student = new Student(
                request.getName(),
                request.getEmail(),
                request.getDepartment(),
                request.getCgpa()
        );
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
    }

    public Student updateStudent(Long id, StudentRequestDTO request) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setDepartment(request.getDepartment());
        student.setCgpa(request.getCgpa());

        return repo.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        repo.delete(student);
    }
}
