package com.example.quizler.quizler.spring

import com.example.quizler.quizler.spring.invalidquestion.repository.InvalidQuestionRepository
import com.example.quizler.quizler.spring.question.repository.QuestionRepository
import com.example.quizler.quizler.spring.quizmode.repository.QuizModeRepository
import com.example.quizler.quizler.spring.reportquestion.repository.QuestionReportTypeRepository
import com.example.quizler.quizler.spring.score.repository.ScoreRepository
import com.example.quizler.quizler.spring.util.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.nio.file.Files
import java.nio.file.Paths

@Configuration
class H2DatabaseInitializer {

    @Bean
    fun initializeDatabase(
        invalidQuestionRepository: InvalidQuestionRepository,
        modeRepository: QuizModeRepository,
        reportTypeRepository: QuestionReportTypeRepository,
        scoreRepository: ScoreRepository,
        questionRepository: QuestionRepository
    ): CommandLineRunner {
        return CommandLineRunner {
            val objectMapper = ObjectMapper().findAndRegisterModules()
            val legacyEntityMapper = LegacyEntityMapper()

            // Load and save InvalidQuestions
            val legacyQuestionsFilePath = Paths.get("src/main/resources/static/db_files/questions.json")
            if (Files.exists(legacyQuestionsFilePath)) {
                val legacyEntities: List<QuestionLegacyEntity> =
                    objectMapper.readValue(Files.readAllBytes(legacyQuestionsFilePath))
                val entities = legacyEntities.map { legacyEntityMapper.map(it) }
                questionRepository.saveAll(entities)
            }

            // Load and save Modes
            val legacyModesFilePath = Paths.get("src/main/resources/static/db_files/modes.json")
            if (Files.exists(legacyModesFilePath)) {
                val legacyEntities: List<QuestionModeLegacyEntity> =
                    objectMapper.readValue(Files.readAllBytes(legacyModesFilePath))
                val entities = legacyEntities.map { legacyEntityMapper.map(it) }
                modeRepository.saveAll(entities)
            }

            // Load and save ReportTypes
            val legacyReportTypesFilePath = Paths.get("src/main/resources/static/db_files/report_types.json")
            if (Files.exists(legacyReportTypesFilePath)) {
                val legacyEntities: List<ReportTypeLegacyEntity> =
                    objectMapper.readValue(Files.readAllBytes(legacyReportTypesFilePath))
                val entities = legacyEntities.map { legacyEntityMapper.map(it) }
                reportTypeRepository.saveAll(entities)
            }

            // Load and save Scores
            val legacyScoresFilePath = Paths.get("src/main/resources/static/db_files/scores.json")
            if (Files.exists(legacyScoresFilePath)) {
                val legacyEntities: List<ScoreLegacyEntity> =
                    objectMapper.readValue(Files.readAllBytes(legacyScoresFilePath))
                val entities = legacyEntities.map { legacyEntityMapper.map(it) }
                scoreRepository.saveAll(entities)
            }
            println("Database initialized")
        }
    }
}