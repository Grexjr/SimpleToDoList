package util.exceptions;

public class TaskNotInList extends RuntimeException {

    public TaskNotInList(){super("Task is not in current list!");}


    public TaskNotInList(String message) {
        super(message);
    }
}
