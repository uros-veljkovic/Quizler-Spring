package com.example.quizler.quizler.spring.quizmode

import org.springframework.data.jpa.repository.JpaRepository

interface QuizModeRepository : JpaRepository<QuizMode, Long>{
    fun findByName(name: String): QuizMode?
}
