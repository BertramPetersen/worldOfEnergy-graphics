package com.worldofenergy.mainDir.textUI;

import com.worldofenergy.mainDir.Command;
import com.worldofenergy.mainDir.DataService;

import java.util.Scanner;


public class Parser {
    /**
     * Scanner used to read user input. Used in {@link #getCommand()}
     */
    private final Scanner reader;
    /**
     * Instance of the interface {@link DataService}.
     */
    private final DataService dataService;

    /**
     * Constructor with a {@link DataService} parameter. Is instantiated in {@link CommandLineClient}
     *
     * @param game a variable of {@link DataService}
     */
    public Parser(DataService game) {
        this.dataService = game;
        this.reader = new Scanner(System.in);
    }

    /**
     * This method reads the player's input and divides it into two variables word1 and word2.
     *
     * @return the command the player has typed. E.g. build windmill
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;
        System.out.print("> ");
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (word1.contains("go")) {
                StringBuilder commandWord = new StringBuilder(word1);

                commandWord.append(" ");
                commandWord.append(tokenizer.next());
                word1 = commandWord.toString();

                if (tokenizer.hasNext()) {
                    word2 = tokenizer.nextLine().strip();
                }
                return dataService.getCommand(word1, word2);
            }
            if (word1.contains("build")) {
                return buildCommand(word1, tokenizer);
            }
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
        return dataService.getCommand(word1, word2);
    }


//    private boolean endTurnPrompt() {
//        boolean Confirmation = false;
//        System.out.println("Do you want to end your turn to proceed with the game?");
//        System.out.println("Y/N");
//        Scanner scanner = new Scanner(System.in);
//        if (!scanner.next().equalsIgnoreCase("y")) {
//            return false;
//        } else return true;
//    }

    /**
     * @param word1     the command the player's has typed. E.g. build
     * @param tokenizer the second word the player has typed. E.g. windmill
     * @return the command the player has typed. E.g. build windmill
     */
    private Command buildCommand(String word1, Scanner tokenizer) {
        StringBuilder Word2 = new StringBuilder();
        String word2 = null;
        if (tokenizer.hasNext()) {
            Word2.append(tokenizer.nextLine().strip());
            word2 = Word2.toString();
            return dataService.getCommand(word1, word2);
        }
        return dataService.getCommand(word1, word2);
    }
}
