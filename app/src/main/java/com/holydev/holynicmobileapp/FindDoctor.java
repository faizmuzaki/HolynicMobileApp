package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FindDoctor extends AppCompatActivity implements View.OnClickListener{
    private TextView parel, doctorcardiologist;
    private ImageButton findlist1, findlist2,findlist3,findlist4, findlist5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        parel = (TextView) findViewById(R.id.parel);
        doctorcardiologist = (TextView) findViewById(R.id.doctorcardiologist);
        findlist1 = (ImageButton) findViewById(R.id.doct1);
        findlist2 = (ImageButton) findViewById(R.id.drparel);
        findlist3 = (ImageButton) findViewById(R.id.drfanny);
        findlist4 = (ImageButton) findViewById(R.id.drmicu);
        findlist5 = (ImageButton) findViewById(R.id.drmuzaki);

        parel.setOnClickListener(this);
        doctorcardiologist.setOnClickListener(this);
        findlist1.setOnClickListener(this);
        findlist2.setOnClickListener(this);
        findlist3.setOnClickListener(this);
        findlist4.setOnClickListener(this);
        findlist5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.parel || view.getId() == R.id.doctorcardiologist || view.getId() == R.id.doct1 || view.getId() == R.id.drparel) {
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.list1);
            i.putExtra("doctorName", "Dr. Farel Sadboy");
            i.putExtra("specialist", "Chardiologist");
            i.putExtra("about", "Perkenalkan, Dokter Farrel Sadboy adalah seorang spesialis jantung atau cardiologist yang berpengalaman dalam bidangnya. Beliau memiliki pengetahuan dan keterampilan yang luas dalam mendiagnosis dan mengobati berbagai kondisi jantung, termasuk serangan jantung, aritmia, dan penyakit jantung koroner. Dokter Farrel Sadboy juga dikenal sebagai dokter yang sangat perhatian terhadap pasiennya, dan selalu berusaha memberikan perawatan yang terbaik untuk kesehatan jantung mereka.");
            startActivity(i);
        }else if(view.getId() == R.id.drfanny){
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.detail2);
            i.putExtra("doctorName", "Dr. Fanny Retza");
            i.putExtra("specialist", "Psychologist");
            i.putExtra("about", "Perkenalkan, Dr. Fanny Retza adalah seorang ahli psikologi atau psychologist yang terampil dalam mendiagnosis dan memberikan perawatan untuk berbagai kondisi mental, emosional, dan perilaku. Beliau memiliki pengetahuan yang luas mengenai berbagai teori psikologi dan teknik terapi, dan selalu berusaha membantu pasiennya untuk mencapai kesehatan mental yang optimal. Dr. Fanny Retza juga dikenal sebagai dokter yang ramah dan terampil dalam membantu pasiennya mengatasi masalah psikologis mereka dengan cara yang aman dan efektif.");
            startActivity(i);
        }else if(view.getId() == R.id.drmicu){
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.detail3);
            i.putExtra("doctorName", "Dr. Micu Tiere");
            i.putExtra("specialist", "Orthopedist");
            i.putExtra("about", "Perkenalkan, dr. Michu Tiere adalah seorang spesialis ortopedi atau orthopedist yang terlatih dalam mendiagnosis dan merawat berbagai jenis masalah tulang, sendi, dan otot. Beliau memiliki pengetahuan yang luas mengenai berbagai teknik operasi, seperti operasi tulang belakang dan penggantian sendi, serta teknik non-operasi, seperti terapi fisik dan obat-obatan. dr. Michu Tiere selalu berusaha memberikan perawatan yang terbaik bagi pasien-pasiennya, dan dikenal sebagai dokter yang sangat berdedikasi dalam bidangnya.");
            startActivity(i);
        }else if(view.getId() == R.id.drmuzaki){
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.list1);
            i.putExtra("doctorName", "Dr. Muzaki");
            i.putExtra("specialist", "Orthopedist");
            i.putExtra("about", "ini dokter muzaki");
            startActivity(i);
        }
    }
}