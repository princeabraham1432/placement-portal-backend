package com.example.portal.dto;

public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String department;
    private Double cgpa;

    public StudentResponseDTO(Long id, String name, String email,
                              String department, Double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.cgpa = cgpa;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public Double getCgpa() {
        return cgpa;
    }
}
