package com.example.quiz_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private int score;

    private int totalQuestions;

    private LocalDateTime startedAt;
    
    private LocalDateTime submittedAt;

    private boolean isLate;


    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
