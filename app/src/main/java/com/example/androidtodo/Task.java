package com.example.androidtodo;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private Date data;
    private boolean done;

    public Task()
    {
        id = UUID.randomUUID();
        data = new Date();
    }

    public void setName(String toString) {
    }

    public Object getDate() {
        return null;
    }

    public boolean isDone() {
        return false;
    }

    public void setDone(boolean isChecked) {

    }
}
