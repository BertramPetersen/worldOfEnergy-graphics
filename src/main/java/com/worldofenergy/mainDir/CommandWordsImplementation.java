package com.worldofenergy.mainDir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implements the interface {@link CommandWords}. This class implements the commands previously created in the ENUM class {@link Commands}.
 * It's main function is to connect each command with its String version.
 */
public class CommandWordsImplementation implements CommandWords {
    /**
     * A HashMap of the available and valid commands of the game. This HashMap serves to create a connection between the Command and its String version.
     * E.g. Build and "Build"
     */
    private final HashMap<String, Commands> validCommands;

    /**
     * For all valid commands, sets the String version of a command and the actual command as a pair. E.g. "go to" and go to.
     */
    public CommandWordsImplementation() {
        validCommands = new HashMap<String, Commands>();
        for (Commands command : Commands.values()) {
            if (command != Commands.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    @Override
    public Commands getCommand(String commandWord) {
        Commands command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return Commands.UNKNOWN;
        }
    }

   // @Override
    //ublic boolean isCommand(String aString) {
     //   return validCommands.containsKey(aString);
    //}

    @Override
    public List<String> getCommandWords() {
        List<String> commandWords = new ArrayList<>();
        for (String commandWord : validCommands.keySet()) {
            commandWords.add(commandWord);
        }
        return commandWords;
    }
}
