package com.worldofenergy.mainDir;

import java.util.List;

public interface CommandWords {
    Commands getCommand(String commandWord);

   // boolean isCommand(String aString);

    List<String> getCommandWords();
}
