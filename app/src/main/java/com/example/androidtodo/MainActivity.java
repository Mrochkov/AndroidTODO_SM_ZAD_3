package com.example.androidtodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends SingleFragmentActivity {

    protected Fragment createFragment() {
        return new TaskFragment();
    }
}