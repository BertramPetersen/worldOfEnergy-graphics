package com.worldofenergy.mainDir.textUI;


import com.worldofenergy.mainDir.*;

public class CommandLineClient {
    private final Parser parser;
    private final DataService game;



    public CommandLineClient() {
        this.game = new Game();
        this.parser = new Parser(game);
    }

    public void play() {
        game.welcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Goodbye.");
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        Commands commandWord = command.getCommandName();

        if (commandWord == Commands.UNKNOWN) {
            System.out.println("I don't recognize this command... :/");
            System.out.println("Type 'help' to see your command options");
            return false;
        }
        if (commandWord == Commands.HELP) {
            System.out.printf("You are at %s And your command words are: \n ", game.whereAmI());
            printHelp();
            System.out.println("You have: " + Wallet.getCoins() + " Coins");
        } else if (commandWord == Commands.GO_TO) {
            if (game.goRoom(command)) {
                game.getRoomDescription();

            } else {
                System.out.println("You can't go there. Go to Airport to access all Countries :)");
            }
        } else if (commandWord == Commands.QUIT) {
            if (game.quit(command)) {
                wantToQuit = true;
            } else {
                System.out.println("Quit what?");
            }
        } else if (commandWord == Commands.BUILD) {

            if (game.construct(command.getCommandValue())) {
                System.out.println("You've successfully built a " + command.getCommandValue());
            }
        } else if (commandWord == Commands.END_TURN) {
            game.updateTurn();
        }
        return wantToQuit;
    }

    private void printHelp() {
        for (String str : game.getCommandDescription()) {
            System.out.println(str + " ");
        }
        game.getPrices();
    }
}
