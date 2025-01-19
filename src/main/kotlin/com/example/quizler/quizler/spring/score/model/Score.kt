package com.example.quizler.quizler.spring.score.model

import jakarta.persistence.*

@Entity
data class Score(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false)
    val score: Int,

    @Column(nullable = false)
    val mode: String
)