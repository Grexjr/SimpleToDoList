package list;

import util.exceptions.FatalRemovalError;
import util.exceptions.TaskNotInList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ToDoList implements Serializable {

    private final ArrayList<Task> items;
    private final ArrayList<Task> completedItems;

    private final String name;

    public ToDoList(){
        this.name = "NULL NAME";
        this.items = new ArrayList<>();
        this.completedItems = new ArrayList<>();
    }

    public ToDoList(String name){
        this.name = name;
        this.items = new ArrayList<>();
        this.completedItems = new ArrayList<>();
    }

    public ArrayList<Task> getTasks(){return items;}
    public ArrayList<Task> getCompletedItems(){return completedItems;}
    public String getName(){return name;}

    public String showCompleted(){
        return Arrays.toString(completedItems.toArray());
    }

    public void addToList(Task listItem){
        items.add(listItem);
    }

    // This uses the iterator object, which is very important for file saving and knowing this in general
    public void completeTask(String taskName){
        Task removedTask = null;
        for(Task t : items){
            if(taskName.equalsIgnoreCase(t.getName())) {
                removedTask = t;
                completedItems.add(t);
            }
        }

        try {
            removeFromList(removedTask.getName());
        } catch (NullPointerException e){
            e.printStackTrace();
            throw new FatalRemovalError();
        }
    }

    public void removeFromList(String taskName){
        if(!checkIfInList(taskName)){
            throw new TaskNotInList();
        }

        // Cannot modify a collection while iterating through it! This is why removeIf exists...
        // Interesting syntax for the removeIf()
        items.removeIf(t -> taskName.equalsIgnoreCase(t.getName()));
    }

    public String[] printList(){
        String titleString = name;
        String itemsString = items.toString();
        return new String[]{titleString,itemsString};
    }

    private boolean checkIfInList(String taskName){
        for(Task t : items){
            if(t.getName().equalsIgnoreCase(taskName)){
                return true;
            }
        }
        return false;
    }


}
