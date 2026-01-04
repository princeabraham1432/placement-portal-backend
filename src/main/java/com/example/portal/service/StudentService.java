package com.example.portal.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.portal.model.Student;
import com.example.portal.repository.StudentRepository;

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

    public Student getStudentById(Long id){
        return repo.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));

    }
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }


}
