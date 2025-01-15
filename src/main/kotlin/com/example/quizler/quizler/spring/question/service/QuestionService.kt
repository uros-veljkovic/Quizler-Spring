package com.example.quizler.quizler.spring.question.service

import com.example.quizler.quizler.spring.question.repository.QuestionRepository
import com.example.quizler.quizler.spring.question.repository.model.Question
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val repository: QuestionRepository,
) {

    fun save(question: Question) = repository.save(question)

    fun updateCount(questionId: Long, isCorrect: Boolean): Question {
        repository
            .findById(questionId)
            .orElseThrow {
                QuestionNotFoundException(questionId)
            }.run {
                val countAnsweredCorrectUpdated = countAnsweredCorrect.takeIf {
                    isCorrect.not()
                } ?: countAnsweredCorrect.inc()

                val countAnsweredWrongUpdated = countAnsweredWrong.takeIf {
                    isCorrect
                } ?: countAnsweredWrong.inc()
                return repository.save(
                    copy(
                        countAnsweredCorrect = countAnsweredCorrectUpdated,
                        countAnsweredWrong = countAnsweredWrongUpdated
                    )
                )
            }
    }
}

class QuestionNotFoundException(id: Long) : Exception("Question with ID: $id has not been found !")