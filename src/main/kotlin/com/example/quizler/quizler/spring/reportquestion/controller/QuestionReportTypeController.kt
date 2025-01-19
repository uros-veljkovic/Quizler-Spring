package com.example.quizler.quizler.spring.reportquestion.controller

import com.example.quizler.quizler.spring.reportquestion.dto.QuestionReportTypeDto
import com.example.quizler.quizler.spring.reportquestion.service.QuestionReportTypeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/report-types")
class QuestionReportTypeController(
    private val service: QuestionReportTypeService
) {
    @GetMapping("/")
    fun getAllReportTypes(): List<QuestionReportTypeDto> = service.getAllReportTypes()
}