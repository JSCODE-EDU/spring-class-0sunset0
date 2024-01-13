package com.springhello.domain.test.entity;

import com.springhello.domain.student.entity.Student;
import com.springhello.domain.student.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DisplayName("Student 클래스")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Student의 classes 필드가 null이면 디폴트값이 생성 된다.")
    void generate_column_withDefaultValue() {
        Student student = Student.builder()
                .name("노을")
                .build();

        Student savedStudent = studentRepository.save(student);

        entityManager.flush();
        entityManager.clear();

        Student findStudent = studentRepository.findById(savedStudent.getId()).get();

        Assertions.assertAll(
                () -> assertThat(findStudent.getId()).isNotNull(),
                () -> assertThat(findStudent.getName()).isEqualTo("노을"),
                () -> assertThat(findStudent.getClasses()).isEqualTo("basic")
        );
    }

}