package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ListDoctor extends AppCompatActivity implements View.OnClickListener{
    private TextView parel, cardiologist, fanny;
    private ImageButton doct1,doct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doctor);
        parel = (TextView) findViewById(R.id.parel);
        cardiologist = (TextView) findViewById(R.id.cardiologist);
        fanny = (TextView) findViewById(R.id.fanny);
        doct1 = (ImageButton) findViewById(R.id.doct1);
        doct2 = (ImageButton) findViewById(R.id.doct2);

        parel.setOnClickListener(this);
        fanny.setOnClickListener(this);
        doct1.setOnClickListener(this);
        doct2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.doct1 || view.getId() == R.id.parel || view.getId() == R.id.cardiologist) {
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.list1);
            i.putExtra("doctorName", "Dr. Farel Sadboy");
            i.putExtra("specialist", "Chardiologist");
            i.putExtra("about", "Perkenalkan, Dokter Farrel Sadboy adalah seorang spesialis jantung atau cardiologist yang berpengalaman dalam bidangnya. Beliau memiliki pengetahuan dan keterampilan yang luas dalam mendiagnosis dan mengobati berbagai kondisi jantung, termasuk serangan jantung, aritmia, dan penyakit jantung koroner. Dokter Farrel Sadboy juga dikenal sebagai dokter yang sangat perhatian terhadap pasiennya, dan selalu berusaha memberikan perawatan yang terbaik untuk kesehatan jantung mereka.");
            startActivity(i);
        }else if(view.getId() == R.id.doct2 || view.getId() == R.id.fanny || view.getId() == R.id.psychologist){
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.detail2);
            i.putExtra("doctorName", "Dr. Fanny Retza");
            i.putExtra("specialist", "Psychologist");
            i.putExtra("about", "Perkenalkan, Dr. Fanny Retza adalah seorang ahli psikologi atau psychologist yang terampil dalam mendiagnosis dan memberikan perawatan untuk berbagai kondisi mental, emosional, dan perilaku. Beliau memiliki pengetahuan yang luas mengenai berbagai teori psikologi dan teknik terapi, dan selalu berusaha membantu pasiennya untuk mencapai kesehatan mental yang optimal. Dr. Fanny Retza juga dikenal sebagai dokter yang ramah dan terampil dalam membantu pasiennya mengatasi masalah psikologis mereka dengan cara yang aman dan efektif.");
            startActivity(i);
        }
    }
}