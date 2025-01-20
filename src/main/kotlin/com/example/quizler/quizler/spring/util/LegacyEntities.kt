package com.example.quizler.quizler.spring.util

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class QuestionLegacyEntity(
    @JsonProperty("_id")
    val id: Map<String, String>,
    val text: String,
    val isApproved: Boolean,
    val countAnsweredCorrect: Map<String, Int>,
    val countAnsweredWrong: Map<String, Int>,
    val categoryId: String,
    val answers: List<AnswerLegacyEntity>,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class AnswerLegacyEntity(
    @JsonProperty("_id")
    val id: Map<String, String>,
    val text: String,
    val isCorrect: Boolean,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class QuestionModeLegacyEntity(
    @JsonProperty("_id")
    val id: Map<String, String>,
    val name: String,
    val submodes: List<SubModeLegacyEntity>,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SubModeLegacyEntity(
    @JsonProperty("_id")
    val id: Map<String, String>,
    val name: String,
    val numberOfHints: Map<String, Int>,
    val numberOfQuestions: Map<String, Int>,
    val timePerQuestion: Map<String, Int>,
    @JsonProperty("__v")
    val version: Int = 0,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ReportTypeLegacyEntity(
    @JsonProperty("_id")
    val id: Map<String, String>,
    val type: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ScoreLegacyEntity(
    @JsonProperty("_id")
    val id: Map<String, String>,
    val username: String,
    val score: Map<String, Int>,
    val mode: String,
)
