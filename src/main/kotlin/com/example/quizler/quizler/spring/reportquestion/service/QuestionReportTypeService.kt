package com.example.quizler.quizler.spring.reportquestion.service

import com.example.quizler.quizler.spring.reportquestion.dto.QuestionReportTypeDto
import com.example.quizler.quizler.spring.reportquestion.mapper.QuestionReportTypeMapper
import com.example.quizler.quizler.spring.reportquestion.repository.QuestionReportTypeRepository
import org.springframework.stereotype.Service

@Service
class QuestionReportTypeService(
    private val repository: QuestionReportTypeRepository,
    private val mapper: QuestionReportTypeMapper
) {
    fun getAllReportTypes(): List<QuestionReportTypeDto> = repository.findAll().map { mapper.toDto(it) }
}