package com.example.quizler.quizler.spring.reportquestion.repository

import com.example.quizler.quizler.spring.reportquestion.model.QuestionReportType
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionReportTypeRepository : JpaRepository<QuestionReportType, Long>