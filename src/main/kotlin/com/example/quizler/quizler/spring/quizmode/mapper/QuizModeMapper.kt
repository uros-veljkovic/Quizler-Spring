package com.example.quizler.quizler.spring.quizmode.mapper

import com.example.quizler.quizler.spring.quizmode.QuizMode
import com.example.quizler.quizler.spring.quizmode.QuizModeDto
import com.example.quizler.quizler.spring.quizmode.SubMode
import com.example.quizler.quizler.spring.quizmode.SubModeDto
import org.springframework.stereotype.Component

@Component
class QuizModeMapper {

    fun toDto(quizMode: QuizMode): QuizModeDto = QuizModeDto(
        id = quizMode.id,
        name = quizMode.name,
        submodes = quizMode.submodes.map { toDto(it) }
    )

    fun toEntity(dto: QuizModeDto): QuizMode = QuizMode(
        id = dto.id ?: 0,
        name = dto.name,
        submodes = dto.submodes.map { toEntity(it) }
    )

    private fun toDto(subMode: SubMode): SubModeDto = SubModeDto(
        id = subMode.id,
        name = subMode.name,
        numberOfHints = subMode.numberOfHints,
        numberOfQuestions = subMode.numberOfQuestions,
        timePerQuestion = subMode.timePerQuestion
    )

    private fun toEntity(dto: SubModeDto): SubMode = SubMode(
        id = dto.id ?: 0,
        name = dto.name,
        numberOfHints = dto.numberOfHints,
        numberOfQuestions = dto.numberOfQuestions,
        timePerQuestion = dto.timePerQuestion
    )
}