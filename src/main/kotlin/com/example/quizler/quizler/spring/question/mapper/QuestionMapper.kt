package com.example.quizler.quizler.spring.question.mapper

import com.example.quizler.quizler.spring.question.dto.QuestionDto
import com.example.quizler.quizler.spring.question.repository.model.Question

class QuestionMapper {
    val answerMapper = AnswerMapper()

    fun toEntity(dto: QuestionDto): Question {
        return Question(
            id = dto.id,
            text = dto.text,
            isApproved = dto.isApproved,
            numberOfTimesReported = dto.numberOfTimesReported,
            categoryId = dto.categoryId,
            countAnsweredCorrect = dto.countAnsweredCorrect,
            countAnsweredWrong = dto.countAnsweredWrong,
            answers = dto.answers.map(answerMapper::toEntity)
        )
    }

    fun toDto(entity: Question): QuestionDto {
        return QuestionDto(
            id = entity.id,
            text = entity.text,
            isApproved = entity.isApproved,
            categoryId = entity.categoryId,
            numberOfTimesReported = entity.numberOfTimesReported,
            countAnsweredCorrect = entity.countAnsweredCorrect,
            countAnsweredWrong = entity.countAnsweredWrong,
            answers = entity.answers.map(answerMapper::toDto)
        )
    }
}
