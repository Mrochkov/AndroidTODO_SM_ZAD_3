package com.example.androidtodo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.format.DateFormat;


import java.util.UUID;

public class TaskFragment extends Fragment {
    private Button dateButton;
    private CheckBox doneCheckBox;
    private Task task;
    private static final String ARG_TASK_ID = "task_id";
    private boolean isTaskUpdated = false;
    private EditText nameField;



    private void saveTask() {
        TaskStorage.getInstance().updateTask(task);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        task = TaskStorage.getInstance().getTask(taskId);
    }

    public static TaskFragment newInstance(UUID taskId){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_TASK_ID, taskId);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(bundle);
        return taskFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_task, container, false);


        nameField = view.findViewById(R.id.task_name);
        nameField.setText(task.getName());

                nameField.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        task.setName(s.toString());

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        isTaskUpdated = true;
                    }
                });


            dateButton = view.findViewById(R.id.task_date);
            dateButton.setText(DateFormat.getDateFormat(getContext()).format(task.getDate()));
            dateButton.setEnabled(false);


             doneCheckBox = view.findViewById(R.id.task_done);
             doneCheckBox.setChecked(task.isDone());
             doneCheckBox.setOnCheckedChangeListener((buttonView, isChecked) ->{
                 task.setDone(isChecked);
             });


        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        if (isTaskUpdated) {
            saveTask();
        }
    }
}
