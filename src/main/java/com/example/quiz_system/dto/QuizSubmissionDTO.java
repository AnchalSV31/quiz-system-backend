package com.example.quiz_system.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizSubmissionDTO {

    private String userName;
    private Map<Long, String> answers;
    // required for time tracking
    private LocalDateTime startedAt;
}