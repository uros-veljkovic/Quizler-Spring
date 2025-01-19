package com.example.quizler.quizler.spring.quizmode.model

import jakarta.persistence.*

/**
 * Quiz mode, like Length, Category or Difficulty
 */
@Entity
data class QuizMode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val submodes: List<SubMode> = mutableListOf()
)

/**
 * Represents submode, like Zen, Exam or Marathon in Length mode
 */
@Entity
data class SubMode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val numberOfHints: Int = 3,

    @Column(nullable = false)
    val numberOfQuestions: Int = 20,

    @Column(nullable = false)
    val timePerQuestion: Int = 20,
)