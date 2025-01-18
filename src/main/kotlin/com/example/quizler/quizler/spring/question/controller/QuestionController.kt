package com.example.quizler.quizler.spring.question.controller

import com.example.quizler.quizler.spring.question.dto.QuestionDto
import com.example.quizler.quizler.spring.question.mapper.QuestionMapper
import com.example.quizler.quizler.spring.question.repository.model.Question
import com.example.quizler.quizler.spring.question.service.QuestionService
import com.example.quizler.quizler.spring.util.handleRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/questions")
class QuestionController(
    private val service: QuestionService,
) {

    private val questionMapper = QuestionMapper()

    @PostMapping("/create")
    fun save(dto: QuestionDto): ResponseEntity<QuestionDto> {
        return handleRequest {
            val entity = service.save(questionMapper.toEntity(dto))
            questionMapper.toDto(entity)
        }
    }

    @GetMapping("/answered")
    fun saveAnswer(dto: QuestionAnsweredDto): ResponseEntity<Unit> {
        return handleRequest { service.saveAnswer(dto.questionId, dto.isCorrect) }
    }
}

data class QuestionAnsweredDto(
    val questionId: Long,
    val isCorrect: Boolean
)