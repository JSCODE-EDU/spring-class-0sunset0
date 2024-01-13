package com.springhello.domain.test.repository;

import com.springhello.domain.test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
