package com.worldofenergy.mainDir.QuizSystem;

import com.worldofenergy.mainDir.PredictionService.EnergyBalance;
import com.worldofenergy.mainDir.PredictionService.Forecast;

/**
 * This interface serves as a security measure to hide certain details from {@link Quiz} and {@link RandomEvent} and only show the important details.
 *
 * @see EnergyBalance
 * @see Forecast
 */
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
