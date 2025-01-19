package com.example.quizler.quizler.spring.score.dto

data class ScoreDto(
    val id: Long? = null,
    val username: String,
    val score: Int,
    val mode: String
)