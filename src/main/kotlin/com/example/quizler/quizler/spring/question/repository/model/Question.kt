package com.example.quizler.quizler.spring.question.repository.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    val id: Long = 0,

    @Column(nullable = false) val text: String = "",

    val isApproved: Boolean = false,

    val numberOfTimesReported: Int = 0,

    var countAnsweredCorrect: Int = 0,

    var countAnsweredWrong: Int = 0,

    @Column(nullable = false)
    @NotBlank(message = "Category ID should not be blank!")
    val categoryId: String,

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    @Size(min = 1, message = "Question must have at least one answer!")
    val answers: List<Answer> = mutableListOf(),

    @Version
    val version: Long = 0
)
