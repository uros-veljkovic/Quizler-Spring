package com.example.quizler.quizler.spring.score.repository

import com.example.quizler.quizler.spring.score.model.Score
import org.springframework.data.jpa.repository.JpaRepository

interface ScoreRepository : JpaRepository<Score, Long>