package com.example.quizler.quizler.spring.question.service

import com.example.quizler.quizler.spring.question.repository.QuestionRepository
import com.example.quizler.quizler.spring.question.repository.model.Question
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class QuestionServiceTest {

    val question = Question(
        id = 1,
        text = "Question",
        isApproved = false,
        numberOfTimesReported = 0,
        countAnsweredCorrect = 0,
        countAnsweredWrong = 0,
        categoryId = "Geography",
    )

    @Autowired
    lateinit var repository: QuestionRepository

    @Autowired
    private lateinit var service: QuestionService

    @Test
    fun `test save should save question using repository`() {
        repository.deleteAll()
        val result = service.save(question)

        assertEquals(question, result)
    }

    @Test
    fun `updateCount should increment correct count when isCorrect is true`() {
        service.save(question)

        val updatedQuestion = service.updateCount(questionId = question.id, isCorrect = true)

        assertEquals(1, updatedQuestion.countAnsweredCorrect)
    }

    @Test
    fun `test updateCount should increment wrong count when isCorrect is false`() {
        service.save(question)

        val updatedQuestion = service.updateCount(questionId = question.id, isCorrect = true)

        assertEquals(1, updatedQuestion.countAnsweredCorrect)
    }

    @Test
    fun `updateCount should throw exception when question is not found`() {
        assertThrows<QuestionNotFoundException> {
            service.updateCount(question.id, isCorrect = true)
        }
    }
}