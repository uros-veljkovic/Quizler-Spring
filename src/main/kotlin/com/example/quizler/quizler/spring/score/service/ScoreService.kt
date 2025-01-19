package com.example.quizler.quizler.spring.score.service

import com.example.quizler.quizler.spring.score.dto.ScoreDto
import com.example.quizler.quizler.spring.score.mapper.ScoreMapper
import com.example.quizler.quizler.spring.score.repository.ScoreRepository
import org.springframework.stereotype.Service

@Service
class ScoreService(
    private val scoreRepository: ScoreRepository,
    private val scoreMapper: ScoreMapper
) {
    fun getAllScores(): List<ScoreDto> =
        scoreRepository.findAll().map(scoreMapper::toDto)

    fun createScore(scoreDto: ScoreDto): ScoreDto {
        val score = scoreMapper.toEntity(scoreDto)
        val savedScore = scoreRepository.save(score)
        return scoreMapper.toDto(savedScore)
    }
}