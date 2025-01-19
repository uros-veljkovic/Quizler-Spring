package com.example.quizler.quizler.spring.reportquestion.mapper

import com.example.quizler.quizler.spring.reportquestion.dto.QuestionReportTypeDto
import com.example.quizler.quizler.spring.reportquestion.model.QuestionReportType
import org.springframework.stereotype.Component

@Component
class QuestionReportTypeMapper {
    fun toDto(entity: QuestionReportType): QuestionReportTypeDto {
        return QuestionReportTypeDto(
            id = entity.id.toString(),
            type = entity.type
        )
    }
}