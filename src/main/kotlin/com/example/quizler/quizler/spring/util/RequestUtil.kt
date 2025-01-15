package com.example.quizler.quizler.spring.util

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


fun <T> handleRequest(operation: () -> T): ResponseEntity<T> {
    return try {
        val result = operation()
        ResponseEntity.ok(result)
    } catch (e: Exception) {
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
    }
}