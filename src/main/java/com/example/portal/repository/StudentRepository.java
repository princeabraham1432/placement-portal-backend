package com.example.portal.repository;

import com.example.portal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDepartmentIgnoreCase(String department);

    List<Student> findByNameContainingIgnoreCase(String name);
}
