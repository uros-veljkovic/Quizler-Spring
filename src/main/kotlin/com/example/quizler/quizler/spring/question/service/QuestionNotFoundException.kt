package com.example.quizler.quizler.spring.question.service

class QuestionNotFoundException(id: Long) : Exception("Question with ID: $id has not been found !")