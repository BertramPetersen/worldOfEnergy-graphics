package com.worldofenergy.mainDir;

/**
 * Implements the {@link Command} interface.
 */
public class CommandImplementation implements Command {
    /**
     * The command input of the player. E.g. Build.
     */
    private final Commands commandName;
    /**
     * The second input of the player. E.g. windmill.
     */
    private final String commandValue;

    /**
     * Constructor that gives the player the ability to do something with the commands. E.g. go to asia
     *
     * @param commandWord the command input of the player. E.g. Build
     * @param secondWord  the second input of the player. E.g. windmill
     */
    public CommandImplementation(Commands commandWord, String secondWord) {
        this.commandName = commandWord;
        this.commandValue = secondWord;
    }

    @Override
    public Commands getCommandName() {
        return commandName;
    }

    @Override
    public String getCommandValue() {
        return commandValue;
    }

   // @Override
    //public boolean isUnknown() {
      //  return (commandName == Commands.UNKNOWN);
   // }

    @Override
    public boolean hasCommandValue() {
        return (commandValue != null);
    }
}
