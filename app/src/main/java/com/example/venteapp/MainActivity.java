package com.example.venteapp;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.venteapp.Controler.ListPhoneActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView textView = findViewById(R.id.welcome);
        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSecondActivity();
            }
        } );
    }

    public void launchSecondActivity() {
        Intent intent = new Intent(this, ListPhoneActivity.class);
        startActivity(intent);
    }
}
