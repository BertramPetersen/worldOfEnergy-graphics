package com.worldofenergy.worldofenergygraphics;

public class Wallet {
    private static int coins=0;


    public static int getCoins() {
        return coins;
    }

    public static void setCoins(int coins) {
        Wallet.coins = coins;
    }

    public static void addCoins(int amount) {
        coins += amount;
    }


    public static void subtractCoins(int amount) {
        coins -= amount;
    }

}


