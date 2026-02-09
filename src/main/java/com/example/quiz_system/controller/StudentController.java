package com.example.quiz_system.controller;

import com.example.quiz_system.dto.QuizSubmissionDTO;
import com.example.quiz_system.entity.Result;
import com.example.quiz_system.service.QuizService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentController {

    private final QuizService quizService;

    public StudentController(QuizService quizService) {
        this.quizService = quizService;
    }

    // STUDENT: Attempt quiz
    @PostMapping("/quizzes/{id}/submit")
    public Result submitQuiz(@PathVariable Long id,
                             @RequestBody QuizSubmissionDTO submission) {
        return quizService.submitQuiz(id, submission);
    }

    // STUDENT: View own result
    @GetMapping("/results/{quizId}")
    public Result getMyResult(@PathVariable Long quizId,
                              @RequestParam String userName) {
        return quizService.getMyResult(quizId, userName);
    }
}
