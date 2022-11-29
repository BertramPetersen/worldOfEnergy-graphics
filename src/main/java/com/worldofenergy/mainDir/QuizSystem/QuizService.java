package com.worldofenergy.mainDir.QuizSystem;

import com.worldofenergy.mainDir.PredictionService.Forecast;

import java.util.ArrayList;

public interface QuizService {
    // Quiz methods
    void takeQuiz();

    // RandomEvent methods
    void initiateRandomEvent(Forecast forecast);

    String getNextQuestion();
    String getNextAnswer();
    String[] getNextOptions();
    void incrementQuiz();
}
