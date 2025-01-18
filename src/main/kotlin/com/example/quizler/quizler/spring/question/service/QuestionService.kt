package com.example.quizler.quizler.spring.question.service

import com.example.quizler.quizler.spring.question.repository.QuestionRepository
import com.example.quizler.quizler.spring.question.repository.model.Question
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val repository: QuestionRepository,
) {

    fun getOne(id: Long): Question {
        return repository.findById(id).orElseThrow { QuestionNotFoundException(id) }
    }

    fun getAll(): List<Question> {
        return repository.findAll()
    }

    fun save(question: Question): Question {
        return repository.save(question)
    }

    fun saveAnswer(questionId: Long, isCorrect: Boolean): Question {
        repository
            .findById(questionId)
            .orElseThrow { QuestionNotFoundException(questionId) }
            .run {

                val correctCount = countAnsweredCorrect.takeIf {
                    isCorrect.not()
                } ?: countAnsweredCorrect.inc()

                val wrongCount = countAnsweredWrong.takeIf {
                    isCorrect
                } ?: countAnsweredWrong.inc()
                return repository.save(
                    copy(
                        countAnsweredCorrect = correctCount,
                        countAnsweredWrong = wrongCount
                    )
                )
            }
    }

    fun reportQuestion(id: Long) {
        repository
            .findById(id)
            .orElseThrow { QuestionNotFoundException(id) }
            ?.run {
                repository.save(copy(numberOfTimesReported = numberOfTimesReported + 1))
            }
    }
}

