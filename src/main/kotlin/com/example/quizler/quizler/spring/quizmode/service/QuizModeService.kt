package com.example.quizler.quizler.spring.quizmode.service

import com.example.quizler.quizler.spring.quizmode.QuizMode
import com.example.quizler.quizler.spring.quizmode.QuizModeRepository
import org.springframework.stereotype.Service

@Service
class QuizModeService(
    private val quizModeRepository: QuizModeRepository,
) {
    fun getAllQuizModes(): List<QuizMode> = quizModeRepository.findAll()

    fun getQuizModeById(id: Long): QuizMode? = quizModeRepository.findById(id).orElse(null)

    fun getByName(name: String): QuizMode? = quizModeRepository.findByName(name)

    fun create(quizMode: QuizMode): QuizMode = quizModeRepository.save(quizMode)
}