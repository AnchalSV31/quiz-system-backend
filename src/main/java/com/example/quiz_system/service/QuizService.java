package com.example.quiz_system.service;

import com.example.quiz_system.dto.QuizSubmissionDTO;
import com.example.quiz_system.entity.Quiz;
import com.example.quiz_system.entity.Result;

import java.util.List;

public interface QuizService {

    Quiz createQuiz(Quiz quiz);

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(Long id);

    Result submitQuiz(Long quizId, QuizSubmissionDTO submission);

    Result getMyResult(Long quizId, String userName);

}