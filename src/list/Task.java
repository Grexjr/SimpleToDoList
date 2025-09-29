package list;

public class Task {

    private final Object[] contents;

    private boolean completeStatus;
    private final String taskName;
    private final String taskDueDate;

    public Task(boolean status, String name, String dueDate){
        this.completeStatus = status;
        this.taskName = name;
        this.taskDueDate = dueDate;
        this.contents = new Object[]{completeStatus,taskName,taskDueDate};
    }

    public Object[] getContents(){return contents;}

    public boolean getStatus(){return completeStatus;}
    public void setStatus(boolean value){this.completeStatus = value;}

    public String getName(){return taskName;}

    public String getDueDate(){return taskDueDate;}

    public String printTask(){return String.format("%s | %s", taskName,taskDueDate);}


}
