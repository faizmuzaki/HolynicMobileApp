package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailDoctor extends AppCompatActivity {
    private ImageButton doctorImage;
    private TextView doctorName, specialist,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_doctor);
        doctorImage = (ImageButton) findViewById(R.id.doctorImage);
        doctorName = (TextView) findViewById(R.id.doctorName);
        specialist = (TextView) findViewById(R.id.specialist);
        about = (TextView) findViewById(R.id.about);
        Bundle b = getIntent().getExtras();
        doctorName.setText(b.getString("doctorName"));
        specialist.setText(b.getString("specialist"));
        about.setText(b.getString("about"));

        int imageResourceId = getIntent().getIntExtra("doctorImage", 0);
        doctorImage.setImageResource(imageResourceId);

    }
}