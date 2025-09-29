package main;

import interact.InputManager;
import util.exceptions.InvalidArgs;
import util.exceptions.TaskNotInList;
import util.exceptions.UnknownCommand;
import interact.output.Printer;
import list.Task;
import list.ToDoList;

public class Application implements InputListener{

    //
    // View
    //
    private final InputManager input;
    private final Printer printer;

    //
    // Model
    //
    private ToDoList list;


    //
    // Application variables
    //
    private boolean isRunning;

    public Application(){
        this.input = new InputManager(this);
        this.printer = new Printer();

        start();
        while(isRunning){run();}
    }


    public Application(InputManager inputter,Printer outputter){
        this.input = inputter;
        this.printer = outputter;

        start();
        while(isRunning){run();}
    }

    public void setList(ToDoList newList){this.list = newList;}
    public void setRunning(boolean value){this.isRunning = value;}

    //
    // InputListener methods
    //
    public void runNew(String listName){
        setList(new ToDoList(listName));
        printer.printMessage(String.format("List %s created!",listName));
    }

    public void runLoad(){

    }

    public void runSave(){

    }

    public void runAdd(String name, String date){ // For some reason adding to list null--not sure why
        list.addToList(new Task(false,name,date));
        printer.printMessage(String.format("Task %s added to list %s",name,list.getName()));
    }

    public void runShow(){
        printer.printMessage(String.format("\n%s:\n",list.getName()));
        for(Task t : list.getTasks()){
            printer.printMessage(t.printTask());
        }
    }

    public void runRemove(String task){
        try {
            list.removeFromList(task);
            printer.printMessage(String.format("%s removed from list!", task));
        } catch(TaskNotInList e){
            printer.printMessage("Unknown task! Type 'show' for list of valid tasks.");
        }
    }

    public void runShowComplete(){
        printer.printMessage(String.format("%n%s completed tasks:%n",list.getName()));
        for(Task t : list.getCompletedItems()){
            printer.printMessage(t.printTask());
        }
    }

    public void runComplete(String taskName){
        list.completeTask(taskName);
    }

    public void runClose(){
        end();
    }

    public void runHelp(){
        printer.printCommands();
    }


    private void start(){
        setRunning(true);
        printer.printMessage("To-Do List program started!");
        printer.printMessage("Please input a command or type help for a list of allowed commands.");
    }

    private void run(){
        try{
            input.askForInput();
        } catch(UnknownCommand e){
            printer.printMessage("Unknown Command! Type 'help' for list of commands.");
        } catch(InvalidArgs e){
            printer.printMessage("Wrong number of arguments for command! Type 'help' for command formats.");
        }
    }

    private void end(){
        setRunning(false);
        printer.printMessage("To-Do List program terminated!");
        System.exit(0);
    }





}
