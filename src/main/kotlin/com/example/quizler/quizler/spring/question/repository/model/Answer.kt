package com.example.quizler.quizler.spring.question.repository.model

import jakarta.persistence.*

@Entity
class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false)
    var text: String = "",

    var isCorrect: Boolean = false,
)
