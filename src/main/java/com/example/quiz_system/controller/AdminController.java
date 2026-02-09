package com.example.quiz_system.controller;

import com.example.quiz_system.entity.Quiz;
import com.example.quiz_system.entity.Result;
import com.example.quiz_system.repository.ResultRepository;
import com.example.quiz_system.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    private final QuizService quizService;
    private final ResultRepository resultRepository;

    public AdminController(QuizService quizService,
                           ResultRepository resultRepository) {
        this.quizService = quizService;
        this.resultRepository = resultRepository;
    }

    // ADMIN: Create quiz
    @PostMapping("/quizzes")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    // ADMIN: View all student results
    @GetMapping("/results")
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
