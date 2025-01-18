package com.example.quizler.quizler.spring.question.dto

class QuestionDto(
    var id: Long = 0,
    var isApproved: Boolean = false,
    var text: String = "",
    var numberOfTimesReported: Int = 0,
    var countAnsweredCorrect: Int = 0,
    var countAnsweredWrong: Int = 0,
    var categoryId: String = "",
    var answers: List<AnswerDto>
)