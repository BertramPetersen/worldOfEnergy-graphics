package com.worldofenergy.mainDir;


/**
 * Class that stores the coins needed to buy energy sources.
 * Wallet is a static class as there is only one wallet in the game. In further development e.g. multiple players, wallet would need to become non-static.
 */
public class Wallet {
    /**
     * Coins is the currency in the game. It is what you need to buy energy sources. e.g. a windmill cost 100 coins.
     */
    private static int coins;

    /**
     * @return the amount of coins in wallet.
     */
    public static int getCoins() {
        return coins;
    }

    /**
     * This setter method is generally used to set the starting amount of {@link #coins} for the player.
     * If Wallet.setCoins(50) is called then, regardless of prior amount of coins in the wallet. The new amount of coins will be 50.
     * @param coins the amount of {@link #coins} that would in the wallet. E.g. 500
     */
    public static void setCoins(int coins) {
        Wallet.coins = coins;
    }

    /**
     * This method adds an amount of {@link #coins} to wallet on top of the current amount.
     * @param amount the amount of {@link #coins} which is added to the wallet. E.g. 50
     */
    public static void addCoins(int amount) {
        coins += amount;
    }

    /**
     * This method subtracts an amount of {@link #coins} from wallet.
     * @param amount the amount of {@link #coins} which is subtracted from the wallet. E.g. 50
     */
    public static void subtractCoins(int amount) {
        coins -= amount;
    }
}


