package com.example.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fragments.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_main);
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, new MainFragment())
                .commit();
    }
}
