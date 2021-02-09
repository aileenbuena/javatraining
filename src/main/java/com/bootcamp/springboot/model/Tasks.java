package com.bootcamp.springboot.model;


public class Tasks {

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(int taskDescription) {
        this.taskDescription = taskDescription;
    }

    int taskID;
    int taskDescription;

}
