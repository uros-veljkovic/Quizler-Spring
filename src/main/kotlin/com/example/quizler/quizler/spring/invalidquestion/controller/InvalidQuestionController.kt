package com.example.quizler.quizler.spring.invalidquestion.controller

import com.example.quizler.quizler.spring.invalidquestion.dto.InvalidQuestionDto
import com.example.quizler.quizler.spring.invalidquestion.service.InvalidQuestionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invalid-question")
class InvalidQuestionController(
    private val service: InvalidQuestionService
) {
    @PostMapping("/")
    fun addInvalidQuestion(@RequestBody dto: InvalidQuestionDto): ResponseEntity<String> {
        return try {
            service.addInvalidQuestion(dto)
            ResponseEntity.ok("Thank you for reporting question")
        } catch (e: Exception) {
            ResponseEntity.status(400).body(e.message)
        }
    }
}