package com.example.quizler.quizler.spring.question.repository.model

import jakarta.persistence.*

@Entity
class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val text: String,

    val isCorrect: Boolean? = null,

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    val question: Question
)
