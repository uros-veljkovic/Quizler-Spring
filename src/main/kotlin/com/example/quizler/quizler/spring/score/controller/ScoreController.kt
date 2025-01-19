package com.example.quizler.quizler.spring.score.controller

import com.example.quizler.quizler.spring.score.dto.ScoreDto
import com.example.quizler.quizler.spring.score.service.ScoreService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scores")
class ScoreController(
    private val scoreService: ScoreService
) {
    @GetMapping("/")
    fun getAllScores(): List<ScoreDto> = scoreService.getAllScores()

    @PostMapping("/")
    fun createScore(@RequestBody scoreDto: ScoreDto): ResponseEntity<ScoreDto> {
        return try {
            ResponseEntity.ok(scoreService.createScore(scoreDto))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(null)
        }
    }
}