package com.zakzackr.todomanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "todos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "title", nullable = false)
    @Column(nullable = false)
    private String title;

//    @Column(name = "description", nullable = false)
    @Column(nullable = false)
    private String description;

    private boolean completed;
}



