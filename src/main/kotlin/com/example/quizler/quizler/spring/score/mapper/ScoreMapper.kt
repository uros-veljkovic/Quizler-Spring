package com.example.quizler.quizler.spring.score.mapper

import com.example.quizler.quizler.spring.score.dto.ScoreDto
import com.example.quizler.quizler.spring.score.model.Score
import org.springframework.stereotype.Component

@Component
class ScoreMapper {
    fun toDto(entity: Score): ScoreDto = ScoreDto(
        id = entity.id,
        username = entity.username,
        score = entity.score,
        mode = entity.mode
    )

    fun toEntity(dto: ScoreDto): Score = Score(
        id = dto.id ?: 0,
        username = dto.username,
        score = dto.score,
        mode = dto.mode
    )
}