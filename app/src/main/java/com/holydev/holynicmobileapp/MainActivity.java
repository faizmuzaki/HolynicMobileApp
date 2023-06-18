package com.holydev.holynicmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.holydev.holynicmobileapp.DashboardPage;
import com.holydev.holynicmobileapp.RegisterPage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            Log.d("MainActivity", "User session exists. Redirecting to DashboardPage.\n");
            startActivity(new Intent(this, DashboardPage.class));
            finish(); // Optional: Close the current activity to prevent going back to it
        }

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.button) {
            FirebaseUser user = auth.getCurrentUser();
            if (user != null) {
                Log.d("MainActivity", "User session exists. Redirecting to DashboardPage.\n");
                i = new Intent(this, DashboardPage.class);
            } else {
                Log.d("MainActivity", "User session does not exist. Redirecting to RegisterPage.\n");
                i = new Intent(this, RegisterPage.class);
            }
            startActivity(i);
        }
    }

}
