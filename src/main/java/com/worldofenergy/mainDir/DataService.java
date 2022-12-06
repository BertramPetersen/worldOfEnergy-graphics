package com.worldofenergy.mainDir;

import com.worldofenergy.mainDir.DTOs.ForecastDTO;
import com.worldofenergy.mainDir.PredictionService.PredictionService;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface responsible for the data and information of in the game.
 */
public interface DataService {
    Command getCommand(String word1, String word2);

    void welcome();

    boolean goRoom(Command command);

    void getRoomDescription();

    boolean quit(Command command);

    boolean construct(String type);

    void updateTurn();

    String whereAmI();

    List<String> getCommandDescription();

    void getPrices();

    int getCoins();

    double getTemp();

    double getTempInc();

    double getCO2();

    double getCO2Inc();

    double getSea();

    double getSeaInc();

    Room getCurrentRoom();

    boolean setCurrentRoom(String destination);

    PredictionService getEnergyBalance();

    double getTotalPowerOutput();

    PredictionService getForecast();

    EnergySource stringToEnergySource(String s);

    boolean getTimeToQuiz();

    boolean getInitRandomEvent();

    void resetQuizSystem();

    ArrayList getQuiz();

    int[] getBuiltEnergy();

    int getTurnCount();

    boolean isDecreasing();

    ForecastDTO getForecastDTO();

    ForecastDTO updateForecastDTO();

    Pair<String, String> getRandomEvent();

}
