package com.example.quizler.quizler.spring.invalidquestion

import com.example.quizler.quizler.spring.invalidquestion.dto.InvalidQuestionDto
import com.example.quizler.quizler.spring.invalidquestion.repository.InvalidQuestionRepository
import com.example.quizler.quizler.spring.invalidquestion.service.InvalidQuestionService
import com.example.quizler.quizler.spring.question.repository.QuestionRepository
import com.example.quizler.quizler.spring.question.repository.model.Question
import com.example.quizler.quizler.spring.reportquestion.model.QuestionReportType
import com.example.quizler.quizler.spring.reportquestion.repository.QuestionReportTypeRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class InvalidQuestionServiceIntegrationTest @Autowired constructor(
    private val invalidQuestionRepository: InvalidQuestionRepository,
    private val questionRepository: QuestionRepository,
    private val reportTypeRepository: QuestionReportTypeRepository,
    private val invalidQuestionService: InvalidQuestionService
) {

    private var questionId = ""
    private var reportTypeId = ""

    @BeforeEach
    fun setup() {
        val question = Question(text = "Sample Question")
        val reportType = QuestionReportType(type = "Non Understandable")
        questionId = questionRepository.save(question).id.toString()
        reportTypeId = reportTypeRepository.save(reportType).id.toString()
    }

    @Test
    fun `test save increments numberOfTimesReported when invalid question exists`() {
        `when reporting existing question`()

        val updatedInvalidQuestion =
            invalidQuestionService.addInvalidQuestion(InvalidQuestionDto(questionId, reportTypeId))
        assertNotNull(updatedInvalidQuestion)
        assertEquals(2, updatedInvalidQuestion.numberOfTimesReported)
    }

    @Test
    fun `should create new invalid question when it does not exist`() {
        `when reporting existing question`()

        val newInvalidQuestion = invalidQuestionRepository.findByQuestionIdAndReportTypeId(questionId, reportTypeId)

        assertNotNull(newInvalidQuestion)
        assertEquals(1, newInvalidQuestion?.numberOfTimesReported)
    }

    @Test
    fun `should throw exception when question does not exist`() {
        assertThrows<IllegalArgumentException> {
            invalidQuestionService.addInvalidQuestion(
                InvalidQuestionDto(
                    questionId = "999", // Non-existent question ID
                    reportTypeId = reportTypeId,
                )
            )
        }
    }

    @Test
    fun `should throw exception when report type does not exist`() {
        assertThrows<IllegalArgumentException> {
            invalidQuestionService.addInvalidQuestion(
                InvalidQuestionDto(
                    questionId = questionId,
                    reportTypeId = "999", // Non-existent reportType ID
                )
            )
        }
    }

    private fun `when reporting existing question`() {
        invalidQuestionService.addInvalidQuestion(
            InvalidQuestionDto(
                questionId = questionId,
                reportTypeId = reportTypeId
            )
        )
    }
}