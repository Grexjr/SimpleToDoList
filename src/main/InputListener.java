package main;

import list.Task;

/// Contains methods involving all the commands that can be used as input
public interface InputListener {

    void runNew(String listName);

    void runLoad();

    void runSave();

    void runAdd(String taskName, String taskDate);

    void runShow();

    void runRemove(String taskName);

    void runShowComplete();

    void runComplete(String taskName);

    void runClose();

    void runHelp();

}
