package com.worldofenergy.worldofenergygraphics;

public enum Commands {

    GO_TO("go to"), QUIT("quit"),HELP("help"),
    UNKNOWN("?"), BUILD("build"), END_TURN("end");

    private String commandName;

    Commands(String commandString){
        this.commandName = commandString;
    }
    public String toString(){
        return commandName;
    }
}
