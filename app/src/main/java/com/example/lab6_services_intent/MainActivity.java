package com.example.lab6_services_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartServiceClicked(View view) {
        DemoService.startActionDemo(this, "Goodbye, I am done running!");
    }

    public void onStopServiceClicked(View view) {
        // we can't do anything here!
    }
}