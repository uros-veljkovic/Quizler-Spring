package com.example.quizler.quizler.spring.question.mapper

import com.example.quizler.quizler.spring.question.dto.AnswerDto
import com.example.quizler.quizler.spring.question.dto.QuestionDto
import com.example.quizler.quizler.spring.question.repository.model.Answer
import com.example.quizler.quizler.spring.question.repository.model.Question
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants

class AnswerMapper() {
    fun toDto(entity: Answer): AnswerDto {
        return AnswerDto(
            id = entity.id,
            text = entity.text,
            isCorrect = entity.isCorrect
        )
    }

    fun toEntity(dto: AnswerDto): Answer {
        return Answer(
            id = dto.id,
            text = dto.text,
            isCorrect = dto.isCorrect
        )
    }
}