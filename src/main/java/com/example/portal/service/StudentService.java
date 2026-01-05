package com.example.portal.service;

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

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id " + id));
    }

    // ✅ UPDATE (Day 3)
    public Student updateStudent(Long id, Student newStudent) {
        Student existing = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id " + id));

        existing.setName(newStudent.getName());
        existing.setEmail(newStudent.getEmail());
        existing.setDepartment(newStudent.getDepartment());
        existing.setCgpa(newStudent.getCgpa());

        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
