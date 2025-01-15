package com.example.quizler.quizler.spring.question.repository

import com.example.quizler.quizler.spring.question.repository.model.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long>