package com.example.quizler.quizler.spring.question.controller

import com.example.quizler.quizler.spring.question.repository.model.Question
import com.example.quizler.quizler.spring.question.service.QuestionService
import com.example.quizler.quizler.spring.util.handleRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/questions")
class QuestionController(
    private val service: QuestionService
) {

    @PostMapping("/create")
    fun create(question: Question): ResponseEntity<Question> {
        return handleRequest { service.save(question) }
    }

    @GetMapping("/answered")
    fun updateAnswerCount(): ResponseEntity<Question> {
        return ResponseEntity.ok(null)
    }
}
