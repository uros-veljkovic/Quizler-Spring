package com.example.quizler.quizler.spring.invalidquestion.model

import jakarta.persistence.*

@Entity
data class InvalidQuestion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val questionId: String = "",

    @Column(nullable = false)
    val reportTypeId: String = "",

    @Column(nullable = false)
    var numberOfTimesReported: Int = 0
)