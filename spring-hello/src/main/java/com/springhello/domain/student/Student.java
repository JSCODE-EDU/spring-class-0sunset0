package com.springhello.domain.student;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "class")
    @ColumnDefault("'basic'")
    private String classes;

    @Builder
    private Student(Long id, String name, String classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }
}