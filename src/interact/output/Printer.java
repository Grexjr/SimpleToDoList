package interact.output;

import interact.Commands;

public class Printer {

    public Printer(){

    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printCommands(){
        for(Commands c: Commands.values()){
            System.out.printf("%s: %s%n",c.getName(),c.getDescription());
        }
    }






}
