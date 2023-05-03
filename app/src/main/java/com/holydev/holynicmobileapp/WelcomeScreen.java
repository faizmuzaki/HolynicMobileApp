package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.button) {
            i = new Intent(this, RegisterPage.class);
            startActivity(i);
        }
    }
}