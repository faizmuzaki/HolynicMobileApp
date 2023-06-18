package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginSuccess extends AppCompatActivity implements View.OnClickListener {
    private Button btn_loginSucces;
    private FirebaseAuth auth;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        btn_loginSucces = (Button) findViewById(R.id.btn_loginSucces);
        btn_loginSucces.setOnClickListener(this);
            textView = findViewById(R.id.textView);
        initFirebaseAuth();
        getData();
    }
    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.btn_loginSucces) {
            i = new Intent(this, DashboardPage.class);
            startActivity(i);
        }
    }
    private void getData() {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            textView.setText("Welcome, " + user.getEmail());
        }
    }
    private void initFirebaseAuth() {
        auth = FirebaseAuth.getInstance();
    }

}