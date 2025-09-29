package util.exceptions;

import interact.Commands;

public class InvalidArgs extends RuntimeException {

    //  Default
    public InvalidArgs(){
        super("Invalid number of arguments for command!");
    }

    public InvalidArgs(String message) {
        super(message);
    }

    public InvalidArgs(Commands cmd){
        super("Invalid arguments! Command " + cmd.getName() + " takes " + cmd.getMaxInputs() + " inputs!");
    }


}
