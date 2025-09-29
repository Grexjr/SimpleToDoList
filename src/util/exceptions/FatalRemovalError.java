package util.exceptions;

public class FatalRemovalError extends RuntimeException {

    public FatalRemovalError(){super("FATAL ERROR: LIST REMOVAL ERROR. PROGRAM TERMINATING");}

    public FatalRemovalError(String message) {
        super(message);
    }
}
