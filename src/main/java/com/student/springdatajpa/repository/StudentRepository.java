package com.student.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
