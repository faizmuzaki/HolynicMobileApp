package com.holydev.holynicmobileapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText etEmailForgotPass;
    private Button btnSendEmail;
    Toolbar tbForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmailForgotPass = findViewById(R.id.edt_email);
        btnSendEmail = findViewById(R.id.btn_forgot);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailForgotPass.getText().toString().trim();
                if (email.isEmpty()){
                    etEmailForgotPass.setError("Please field your email");
                    etEmailForgotPass.requestFocus();
                    return;
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    etEmailForgotPass.setError("Please use valid email");
                    etEmailForgotPass.requestFocus();
                    return;
                }else{
                    forgotPass(email);
                }
            }
        });

    }

    private void forgotPass(String email) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgotPassword.this, "Your reset password has been sent to your email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgotPassword.this, LoginPage.class));
                            finishAffinity();
                        }else{
                            Toast.makeText(ForgotPassword.this, "Failed reset password", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgotPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
