package com.example.quizler.quizler.spring.util

import com.example.quizler.quizler.spring.question.repository.model.Answer
import com.example.quizler.quizler.spring.question.repository.model.Question
import com.example.quizler.quizler.spring.quizmode.model.QuizMode
import com.example.quizler.quizler.spring.quizmode.model.SubMode
import com.example.quizler.quizler.spring.reportquestion.model.QuestionReportType
import com.example.quizler.quizler.spring.score.model.Score

class LegacyEntityMapper {

    fun map(legacyEntity: QuestionLegacyEntity): Question {
        val question = Question(
            id = legacyEntity.id["\$oid"]?.toLongOrNull() ?: 0L,
            text = legacyEntity.text,
            isApproved = legacyEntity.isApproved,
            countAnsweredCorrect = legacyEntity.countAnsweredCorrect["\$numberInt"] ?: 0,
            countAnsweredWrong = legacyEntity.countAnsweredWrong["\$numberInt"] ?: 0,
            categoryId = legacyEntity.categoryId,
            answers = legacyEntity.answers.map {
                Answer(
                    id = it.id["\$oid"]?.toLongOrNull() ?: 0L,
                    text = it.text,
                    isCorrect = it.isCorrect
                )
            }
        )
        return question
    }

    fun map(legacyEntity: QuestionModeLegacyEntity): QuizMode {
        val mode = QuizMode(
            id = legacyEntity.id["\$oid"]?.toLongOrNull() ?: 0L,
            name = legacyEntity.name,
            submodes = legacyEntity.submodes.map {
                SubMode(
                    id = it.id["\$oid"]?.toLongOrNull() ?: 0L,
                    name = it.name,
                    numberOfHints = it.numberOfHints["\$numberInt"] ?: 3,
                    numberOfQuestions = it.numberOfQuestions["\$numberInt"] ?: 20,
                    timePerQuestion = it.timePerQuestion["\$numberInt"] ?: 20
                )
            }
        )

        return mode
    }

    fun map(legacyEntity: ReportTypeLegacyEntity): QuestionReportType {
        return QuestionReportType(
            id = legacyEntity.id["\$oid"]?.toLongOrNull() ?: 0L,
            type = legacyEntity.type
        )
    }

    fun map(legacyEntity: ScoreLegacyEntity): Score {
        return Score(
            id = legacyEntity.id["\$oid"]?.toLongOrNull() ?: 0L,
            username = legacyEntity.username,
            score = legacyEntity.score["\$numberInt"] ?: 0,
            mode = legacyEntity.mode
        )
    }
}
