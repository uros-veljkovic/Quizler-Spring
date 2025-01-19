package com.example.quizler.quizler.spring.quizmode.repository

import com.example.quizler.quizler.spring.quizmode.model.QuizMode
import org.springframework.data.jpa.repository.JpaRepository

interface QuizModeRepository : JpaRepository<QuizMode, Long>{
    fun findByName(name: String): QuizMode?
}
