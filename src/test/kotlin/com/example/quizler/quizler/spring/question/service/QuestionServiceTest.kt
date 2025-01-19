package com.example.quizler.quizler.spring.question.service

import com.example.quizler.quizler.spring.question.repository.QuestionRepository
import com.example.quizler.quizler.spring.question.repository.model.Question
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class QuestionServiceTest @Autowired constructor(
    private val repository: QuestionRepository,
    private val service: QuestionService
) {

    val question = Question(
        text = "Question",
        isApproved = false,
        numberOfTimesReported = 0,
        countAnsweredCorrect = 0,
        countAnsweredWrong = 0,
        categoryId = "Geography",
    )


    @AfterEach
    fun afterEach() {
        repository.deleteAll()
    }

    @Test
    fun `test getAll returns all questions should save question using repository`() {
        repeat(10) {
            service.save(Question(text = "Text", categoryId = "ID"))
        }

        assertEquals(10, service.getAll().size)
    }

    @Test
    fun `test save should save question using repository`() {
        val result = service.save(question)

        assertEquals(question, result)
    }

    @Test
    fun `test saveAnswer when question answered correctly`() {
        service.save(question)

        val updatedQuestion = service.saveAnswer(questionId = question.id, isCorrect = true)

        assertEquals(1, updatedQuestion.countAnsweredCorrect)
        assertEquals(0, updatedQuestion.countAnsweredWrong)
    }

    @Test
    fun `test saveAnswer when question answered wrong`() {
        service.save(question)

        val updatedQuestion = service.saveAnswer(questionId = question.id, isCorrect = false)

        assertEquals(0, updatedQuestion.countAnsweredCorrect)
        assertEquals(1, updatedQuestion.countAnsweredWrong)
    }

    @Test
    fun `test saveAnswer should throw exception when question is not found`() {
        assertThrows<QuestionNotFoundException> {
            service.saveAnswer(question.id, isCorrect = true)
        }
    }

    @Test
    fun `test reportQuestion increments number of times question reported`() {
        val question = Question(text = "text", numberOfTimesReported = 0)
        service.save(question)
        service.reportQuestion(question.id)

        val timesReported = service.getOne(question.id).numberOfTimesReported
        assertEquals(1, timesReported)
    }

    @Test
    fun `test reportQuestion throws exception when question does not exist`() {
        assertThrows<QuestionNotFoundException> {
            service.reportQuestion(123)
        }
    }
}