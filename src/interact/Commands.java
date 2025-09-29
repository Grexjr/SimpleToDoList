package interact;

/// The list of commands the user can use for certain actions
public enum Commands {

    NEW(
            "new",
            "Creates a new list.\nForm: new (name)",
            1
    ),
    LOAD(
            "load",
            "Loads a list from file.\nForm: load (name)",
            1
    ),
    SAVE(
            "save",
            "Saves the current list to file.\nForm: save ()",
            0
    ),
    ADD(
            "add",
            "Adds a task to the current list.\nForm: add (taskName taskDueDate)",
            2
    ),
    SHOW(
            "show",
            "Shows all the tasks on the current list.\nForm: show ()",
            0
    ),
    REMOVE(
            "remove",
            "Removes a task from the current list.\nForm: remove (taskName)",
            1
    ),
    SHOWC(
            "showc",
            "Shows all completed tasks of the current list.\nForm: showc ()",
            0
    ),
    COMPLETE(
            "complete",
            "Completes a task on the current list.\nForm: complete (taskName)",
            1
    ),
    CLOSE(
            "close",
            "Closes the program.\nForm: close ()",
            0
    ),
    HELP(
            "help",
            "Brings up the help menu.\nForm: help ()",
            0
    );

    private final String name;
    private final String description;
    private final int allowedInputs;

    Commands(String commandString, String commandDescription, int limit){
        this.name = commandString;
        this.description = commandDescription;
        this.allowedInputs = limit;
    }

    public String getName(){return name;}
    public String getDescription(){return description;}
    public int getMaxInputs(){return allowedInputs;}

    /**
     * Validates the input to ensure that it is a proper command. Static method in the enum.
     * @param input the inputted string, which will be from the user
     * @return boolean value if the input is a valid command
     */
    public static boolean isValid(String input){
        // Try catch block; if the input matches, it returns true, if not, err thrown and returns false
        try{
            Commands.valueOf(input.toUpperCase());
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    /**
     * Validates the input to ensure that it lines up with the proper amount of arguments for the command.
     * @param cmd the command to be compared for its arguments length
     * @param parsedInput the input of the user to compare the length for the arguments
     * @return true if the input array minus one equals the inputs list of the command
     * */
    public static boolean isSound(Commands cmd, String[] parsedInput){
        return parsedInput.length - 1 == cmd.getMaxInputs();
    }


}
