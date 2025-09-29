package util.exceptions;

public class UnknownCommand extends RuntimeException {
    //  Default
    public UnknownCommand(){
        super("Unknown Command! Type 'help' for list of commands.");
    }

    //  Specific
    public UnknownCommand(String message) {
        super(message);
    }

}
