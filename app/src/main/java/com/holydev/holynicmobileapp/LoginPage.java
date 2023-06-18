package com.holydev.holynicmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    private EditText etEmailSignIn,etPasswordSignIn;
    private FirebaseAuth auth;
    private TextView register, forgotpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        etEmailSignIn = findViewById(R.id.edt_email);
        etPasswordSignIn = findViewById(R.id.edt_password);
        register = (TextView) findViewById(R.id.register);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        initFirebaseAuth();

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailSignIn.getText().toString().trim();
                String pass = etPasswordSignIn.getText().toString().trim();

                if (checkValidation(email, pass)) {
                    loginToServer(email, pass);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, RegisterPage.class));
            }

        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, ForgotPassword.class));
            }

        });
//        findViewById(R.id.btnForgotPass).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignInActivity.this, ForgotPasswordActivity.class));
//            }
//        });

//        tbSignIn.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    private void loginToServer(String email, String pass) {
        AuthCredential credential = EmailAuthProvider.getCredential(email, pass);
        fireBaseAuth(credential);
    }

    private void fireBaseAuth(AuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        CustomDialog.hideLoading();
                        if (task.isSuccessful()) {
                            startActivity(new Intent(LoginPage.this, LoginSuccess.class));
                            finishAffinity();
                        } else {
                            Toast.makeText(LoginPage.this, "Sign-In failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        CustomDialog.hideLoading();
                        Toast.makeText(LoginPage.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private boolean checkValidation(String email, String pass) {
        if (email.isEmpty()) {
            etEmailSignIn.setError("Please field your email");
            etEmailSignIn.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailSignIn.setError("Please use valid email");
            etEmailSignIn.requestFocus();
        } else if (pass.isEmpty()) {
            etPasswordSignIn.setError("Please field your password");
            etPasswordSignIn.requestFocus();
        } else {
            return true;
        }
        CustomDialog.hideLoading();
        return false;
    }

    private void initFirebaseAuth() {
        auth = FirebaseAuth.getInstance();
    }


}