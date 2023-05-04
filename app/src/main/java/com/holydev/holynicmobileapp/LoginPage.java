package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        btn_login = (Button) findViewById(R.id.btn_login);
        register = (TextView) findViewById(R.id.register);

        btn_login.setOnClickListener(this);
        register.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.btn_login) {
            i = new Intent(this, LoginSuccess.class);
            startActivity(i);
        }else if (view.getId() == R.id.register) {
            i = new Intent(this, RegisterPage.class);
            startActivity(i);
        }
    }
}