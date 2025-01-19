package com.example.quizler.quizler.spring.reportquestion.model

import jakarta.persistence.*

@Entity
data class QuestionReportType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val type: String
)