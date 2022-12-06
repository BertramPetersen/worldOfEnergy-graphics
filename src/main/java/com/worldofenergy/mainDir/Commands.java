package com.worldofenergy.mainDir;

/**
 * An enum class wherein the commands available to the player is defined.
 */
public enum Commands {

    /**
     * Allows the player to go to different regions. E.g. "go to asia".
     */
    GO_TO("go to"),

    /**
     * Allows the player to quit the game.
     */
    QUIT("quit"),

    /**
     * Displays the current location of the player and all their available commands.
     * Also displays energy-construction prices and amount of coins in wallet.
     */
    HELP("help"),

    /**
     * Tells the player that their input is not a valid command in case the player types an unknown command. Suggests the player can type help.
     */
    UNKNOWN("?"),

    /**
     * Allows the player to build energy-constructions. E.g. "build windmill".
     */
    BUILD("build"),

    /**
     * Allows the player to end their turn.
     */
    END_TURN("end");

    /**
     * Field variable of type String. Used in the {@link Commands} constructor.
     */
    private final String commandString;

    /**
     * Each ENUM takes in a value of the field variable {@link #commandString}. E.g. END_TURN = "end".
     *
     * @param commandString the input the user has to type to activate the command
     */
    Commands(String commandString) {
        this.commandString = commandString;
    }

    /**
     * @return a string representation of the value of commandString
     */
    public String toString() {
        return commandString;
    }
}
