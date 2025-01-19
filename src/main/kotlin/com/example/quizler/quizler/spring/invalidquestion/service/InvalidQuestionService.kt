package com.example.quizler.quizler.spring.invalidquestion.service

import com.example.quizler.quizler.spring.invalidquestion.dto.InvalidQuestionDto
import com.example.quizler.quizler.spring.invalidquestion.model.InvalidQuestion
import com.example.quizler.quizler.spring.invalidquestion.repository.InvalidQuestionRepository
import com.example.quizler.quizler.spring.question.repository.QuestionRepository
import com.example.quizler.quizler.spring.reportquestion.repository.QuestionReportTypeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InvalidQuestionService(
    private val questionRepository: QuestionRepository,
    private val reportReportType: QuestionReportTypeRepository,
    private val invalidQuestionRepository: InvalidQuestionRepository
) {
    @Transactional
    fun addInvalidQuestion(dto: InvalidQuestionDto): InvalidQuestion {
        questionRepository.findById(dto.questionId.toLong()).orElseThrow {
            IllegalArgumentException("Invalid question ID: ${dto.questionId}")
        }

        reportReportType.findById(dto.reportTypeId.toLong()).orElseThrow {
            IllegalArgumentException("Invalid report type ID: ${dto.reportTypeId}")
        }

        val existingInvalidQuestion = invalidQuestionRepository.findByQuestionIdAndReportTypeId(
            questionId = dto.questionId,
            reportTypeId = dto.reportTypeId
        )

        if (existingInvalidQuestion != null) {
            existingInvalidQuestion.numberOfTimesReported += 1
            return invalidQuestionRepository.save(existingInvalidQuestion)
        } else {
            return invalidQuestionRepository.save(
                InvalidQuestion(
                    reportTypeId = dto.reportTypeId,
                    questionId = dto.questionId,
                    numberOfTimesReported = 1
                )
            )
        }
    }
}