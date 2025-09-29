package interact;

import util.exceptions.InvalidArgs;
import util.exceptions.UnknownCommand;
import main.InputListener;

import java.util.Scanner;

public class InputManager {

    private final InputListener inputListener;
    private final Scanner inputReader;

    private String rawInput;
    private String[] parsedInput;

    public InputManager(InputListener listener){
        this.inputListener = listener;
        this.inputReader = new Scanner(System.in);

    }

    public InputListener getInputListener(){return inputListener;}
    public Scanner getInputReader(){return inputReader;}

    public void askForInput(){
        retrieveInput();
        runInput();
    }

    /**
     * Runs the input from the user depending on what command they input
     * @throws UnknownCommand if not a valid command
     * @throws InvalidArgs if incorrect number of arguments provided
     */
    //TODO: Will need to handle the other things that come with the command; inputs with them
    //TODO: Add throw lines and throw description to the javadoc
    public void runInput(){
        // Learned this from a YouTube video! Inversion
        // Checks if the command is a valid one
        if(!validateInput()){
            throw new UnknownCommand();
        }

        // If valid, parses the command and sets the command to the first value of the parsed string
        Commands cmd = Commands.valueOf(parsedInput[0].toUpperCase());

        // Checks if the valid command has the correct number of args
        if(!validateArgs()){
            throw new InvalidArgs(cmd);
        }

        // If yes, run this switch statement
        // Switch to determine what functionality to run based on the command inputted
        switch(cmd){
            case NEW -> {
                inputListener.runNew(parsedInput[1]);
            }
            case LOAD -> {
                inputListener.runLoad();
            }
            case SAVE -> {
                inputListener.runSave();
            }
            case ADD -> {
                inputListener.runAdd(parsedInput[1],parsedInput[2]);
            }
            case SHOW -> {
                inputListener.runShow();
            }
            case REMOVE -> {
                inputListener.runRemove(parsedInput[1]);
            }
            case SHOWC -> {
                inputListener.runShowComplete();
            }
            case COMPLETE -> {
                inputListener.runComplete(parsedInput[1]);
            }
            case CLOSE -> {
                inputListener.runClose();
            }
            case HELP -> {
                inputListener.runHelp();
            }
        }
    }

    /**
     * Checks if the first string entered by the user is a valid command.
     * @return true if the first value of the parsed input is a valid command
     * */
    private boolean validateInput(){
        String[] input = parseInput();
        // May want to separate underneath out for separate errors
        return input.length > 0 && Commands.isValid(input[0]);
    }

    /**
     * Validates the number of arguments provided
     * */
    private boolean validateArgs(){
        String[] input = parseInput();
        Commands cmd = Commands.valueOf(input[0].toUpperCase());

        return Commands.isSound(cmd,input);
    }

    /**
     * Parses the input by delimiting it based on spaces, which this .split() method accomplishes. One can use any
     * delimiter, but for ease of the user it has been simplified so just a space delimits new commands/inputs.
     * @return the array of split inputs. The first will be checked if it is a proper command.
     * */
    private String[] parseInput(){
        String input = rawInput;
        this.parsedInput = input.split(" ");
        return this.parsedInput;
    }

    /**
     * Retrieves user input to be used in the program and stores it in the local variable
     * */
    private void retrieveInput(){
        rawInput = inputReader.nextLine();
    }


}
