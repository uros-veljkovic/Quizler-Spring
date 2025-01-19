package com.example.quizler.quizler.spring.quizmode.dto

data class QuizModeDto(
    val id: Long?,
    val name: String,
    val submodes: List<SubModeDto>
)

data class SubModeDto(
    val id: Long?,
    val name: String,
    val numberOfHints: Int,
    val numberOfQuestions: Int,
    val timePerQuestion: Int
)