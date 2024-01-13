package com.springhello.domain.student;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
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
    private Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }
}