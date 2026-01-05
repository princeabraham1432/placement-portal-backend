package com.example.portal.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.portal.model.Student;
import com.example.portal.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {
        return service.updateStudent(id, student);
    }





}
