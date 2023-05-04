package com.holydev.holynicmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DashboardPage extends AppCompatActivity implements View.OnClickListener {
    private ImageButton hospital, doctor, pharmacy, notif, article, doctor1, doctor2, doctor3;
    private TextView see, textdoctor, pharma, see_all, namedoctor1, namedoctor2, namedoctor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        see = (TextView) findViewById(R.id.see);
        textdoctor = (TextView) findViewById(R.id.textdoctor);
        pharma = (TextView) findViewById(R.id.pharma);
        see_all = (TextView) findViewById(R.id.see_all);
        namedoctor1 = (TextView) findViewById(R.id.namedoctor1);
        namedoctor2 = (TextView) findViewById(R.id.namedoctor2);
        namedoctor3 = (TextView) findViewById(R.id.namedoctor3);

        hospital = (ImageButton) findViewById(R.id.hospital);
        doctor = (ImageButton) findViewById(R.id.doctor);
        pharmacy = (ImageButton) findViewById(R.id.pharmacy);
        notif = (ImageButton) findViewById(R.id.notif);
        article = (ImageButton) findViewById(R.id.doctor1);
        doctor1 = (ImageButton) findViewById(R.id.article);
        doctor2 = (ImageButton) findViewById(R.id.doctor2);
        doctor3 = (ImageButton) findViewById(R.id.doctor3);


        see.setOnClickListener(this);
        hospital.setOnClickListener(this);
        textdoctor.setOnClickListener(this);
        doctor.setOnClickListener(this);
        pharma.setOnClickListener(this);
        pharmacy.setOnClickListener(this);
        see_all.setOnClickListener(this);
        article.setOnClickListener(this);
        notif.setOnClickListener(this);
        namedoctor1.setOnClickListener(this);
        namedoctor2.setOnClickListener(this);
        namedoctor3.setOnClickListener(this);
        doctor1.setOnClickListener(this);
        doctor2.setOnClickListener(this);
        doctor3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.see) {
            i = new Intent(this, ListDoctor.class);
            startActivity(i);
        } else if (view.getId() == R.id.hospital) {
            i = new Intent(this, ListHospital.class);
            startActivity(i);
        } else if (view.getId() == R.id.doctor || view.getId() == R.id.textdoctor) {
            i = new Intent(this, FindDoctor.class);
            startActivity(i);
        } else if (view.getId() == R.id.pharma || view.getId() == R.id.pharmacy) {
            i = new Intent(this, PharmacyActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.notif) {
            i = new Intent(this, NotificationActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.see_all || view.getId() == R.id.article) {
            i = new Intent(this, ArticleActivity.class);
            startActivity(i);
        }else if (view.getId() == R.id.namedoctor1 || view.getId() == R.id.doctor1) {
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.list1);
            i.putExtra("doctorName", "Dr. Farel Sadboy");
            i.putExtra("specialist", "Chardiologist");
            i.putExtra("about", "Perkenalkan, Dokter Farrel Sadboy adalah seorang spesialis jantung atau cardiologist yang berpengalaman dalam bidangnya. Beliau memiliki pengetahuan dan keterampilan yang luas dalam mendiagnosis dan mengobati berbagai kondisi jantung, termasuk serangan jantung, aritmia, dan penyakit jantung koroner. Dokter Farrel Sadboy juga dikenal sebagai dokter yang sangat perhatian terhadap pasiennya, dan selalu berusaha memberikan perawatan yang terbaik untuk kesehatan jantung mereka.");
            startActivity(i);
        }else if(view.getId() == R.id.namedoctor2 || view.getId() == R.id.doctor2){
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage",R.drawable.detail2);
            i.putExtra("doctorName", "Dr. Fanny Retza");
            i.putExtra("specialist", "Psychologist");
            i.putExtra("about", "Perkenalkan, Dr. Fanny Retza adalah seorang ahli psikologi atau psychologist yang terampil dalam mendiagnosis dan memberikan perawatan untuk berbagai kondisi mental, emosional, dan perilaku. Beliau memiliki pengetahuan yang luas mengenai berbagai teori psikologi dan teknik terapi, dan selalu berusaha membantu pasiennya untuk mencapai kesehatan mental yang optimal. Dr. Fanny Retza juga dikenal sebagai dokter yang ramah dan terampil dalam membantu pasiennya mengatasi masalah psikologis mereka dengan cara yang aman dan efektif.");
            startActivity(i);
        }else if(view.getId() == R.id.namedoctor3 || view.getId() == R.id.doctor3) {
            i = new Intent(this, DetailDoctor.class);
            i.putExtra("doctorImage", R.drawable.detail3);
            i.putExtra("doctorName", "Dr. Micu Tiere");
            i.putExtra("specialist", "Orthopedist");
            i.putExtra("about", "Perkenalkan, dr. Michu Tiere adalah seorang spesialis ortopedi atau orthopedist yang terlatih dalam mendiagnosis dan merawat berbagai jenis masalah tulang, sendi, dan otot. Beliau memiliki pengetahuan yang luas mengenai berbagai teknik operasi, seperti operasi tulang belakang dan penggantian sendi, serta teknik non-operasi, seperti terapi fisik dan obat-obatan. dr. Michu Tiere selalu berusaha memberikan perawatan yang terbaik bagi pasien-pasiennya, dan dikenal sebagai dokter yang sangat berdedikasi dalam bidangnya.");
            startActivity(i);
        }
    }
}