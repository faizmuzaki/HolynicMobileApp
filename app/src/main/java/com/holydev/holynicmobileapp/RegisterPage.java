package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener{
    private Button btn_register;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        btn_register = (Button) findViewById(R.id.btn_register);
        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.btn_register) {
            i = new Intent(this, LoginPage.class);
            startActivity(i);
        }else if (view.getId() == R.id.login) {
            i = new Intent(this, LoginPage.class);
            startActivity(i);
        }
    }
}