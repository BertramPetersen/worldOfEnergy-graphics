package com.worldofenergy.mainDir;

public interface Command {

    Commands getCommandName();

    String getCommandValue();

    boolean hasCommandValue();

    boolean isUnknown();
}
