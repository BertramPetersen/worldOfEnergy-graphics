package com.worldofenergy.mainDir.QuizSystem;

import com.worldofenergy.mainDir.PredictionService.Forecast;

public interface QuizService {
    // Quiz methods
    void takeQuiz();

    // RandomEvent methods
    void initiateRandomEvent(Forecast forecast);

     String getNextQuestion();
}
