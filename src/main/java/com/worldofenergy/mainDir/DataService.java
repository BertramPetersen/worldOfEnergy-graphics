package com.worldofenergy.mainDir;

import java.util.List;

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

}
