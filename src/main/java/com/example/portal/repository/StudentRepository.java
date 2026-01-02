package com.example.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.portal.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
