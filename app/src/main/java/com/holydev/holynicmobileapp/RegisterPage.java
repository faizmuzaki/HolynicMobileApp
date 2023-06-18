package com.holydev.holynicmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    private EditText etEmailSignUp, etPasswordSignUp, etConfirmPasswordSignUp;
    private Button btnSignUp;
    private TextView login;
    Toolbar tbSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        etEmailSignUp = findViewById(R.id.edt_email_reg);
        etPasswordSignUp = findViewById(R.id.edt_password_reg);
        etConfirmPasswordSignUp = findViewById(R.id.edt_confirmPassword_reg);
        btnSignUp = findViewById(R.id.btn_register);
        login = (TextView) findViewById(R.id.login);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailSignUp.getText().toString().trim();
                String pass = etPasswordSignUp.getText().toString().trim();
                String confirmPass = etConfirmPasswordSignUp.getText().toString().trim();

                CustomDialog.showLoading(RegisterPage.this);
                if (checkValidation(email, pass, confirmPass)){
                    registerToServer(email, pass);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterPage.this, LoginPage.class));
                }

        });

    }

    private void registerToServer(String email, String pass) {
        FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        CustomDialog.hideLoading();
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterPage.this, "Your account created successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterPage.this, LoginPage.class));
                            finishAffinity();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        CustomDialog.hideLoading();
                        String errorMessage = "Authentication failed: " + e.getMessage();
                        Toast.makeText(RegisterPage.this, errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private boolean checkValidation(String email, String pass, String confirmPass) {
        if (email.isEmpty()){
            etEmailSignUp.setError("Please field your email");
            etEmailSignUp.requestFocus();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmailSignUp.setError("Please use valid email");
            etEmailSignUp.requestFocus();
        }else if (pass.isEmpty()){
            etPasswordSignUp.setError("Please field your password");
            etPasswordSignUp.requestFocus();
        }else if (confirmPass.isEmpty()){
            etConfirmPasswordSignUp.setError("Please field your confirm password");
            etConfirmPasswordSignUp.requestFocus();
        }else if (!pass.equals(confirmPass)){
            etPasswordSignUp.setError("Your pass didn't match");
            etConfirmPasswordSignUp.setError("Your confirm pass didn't match");

            etPasswordSignUp.requestFocus();
            etConfirmPasswordSignUp.requestFocus();
        }else{
            etPasswordSignUp.setError(null);
            etConfirmPasswordSignUp.setError(null);
            return true;
        }
        CustomDialog.hideLoading();
        return false;
    }

}
