package com.example.androidtodo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class  TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks;

    public static TaskStorage getInstance() {
        return taskStorage;
    }

    public void updateTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(task.getId())) {
                tasks.set(i, task);
                break;
            }
        }
    }


    private TaskStorage() {
        final int tasksCount = 105;
        tasks = new ArrayList<>();
        for (int i = 1; i <= tasksCount; i++) {
            Task task = new Task();
            task.setName("Zadanie numer " + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public List<Task> getTaskList() {
        return tasks;
    }

    public Task getTask(UUID taskId) {
        for(Task task:tasks){
            if(task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}