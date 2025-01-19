package com.example.quizler.quizler.spring.quizmode.controller

import com.example.quizler.quizler.spring.quizmode.dto.QuizModeDto
import com.example.quizler.quizler.spring.quizmode.mapper.QuizModeMapper
import com.example.quizler.quizler.spring.quizmode.service.QuizModeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/quiz-modes")
class QuizModeController(
    private val quizModeService: QuizModeService,
    private val quizModeMapper: QuizModeMapper
) {
    @GetMapping
    fun getAllQuizModes(): List<QuizModeDto> {
        return quizModeService.getAllQuizModes().map { quizModeMapper.toDto(it) }
    }

    @GetMapping("/{id}")
    fun getQuizModeById(@PathVariable id: Long): ResponseEntity<QuizModeDto> {
        val quizMode = quizModeService.getQuizModeById(id)
        return if (quizMode != null) {
            ResponseEntity.ok(quizModeMapper.toDto(quizMode))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{name}")
    fun getMode(@PathVariable name: String): ResponseEntity<QuizModeDto> {
        val quizMode = quizModeService.getByName(name)
        return if (quizMode != null) {
            ResponseEntity.ok(quizModeMapper.toDto(quizMode))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createQuizMode(@RequestBody quizModeDto: QuizModeDto): QuizModeDto {
        val quizMode = quizModeMapper.toEntity(quizModeDto)
        return quizModeMapper.toDto(quizModeService.create(quizMode))
    }
}