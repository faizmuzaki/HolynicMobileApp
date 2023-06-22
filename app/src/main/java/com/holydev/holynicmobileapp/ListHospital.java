package com.holydev.holynicmobileapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.holydev.holynicmobileapp.databinding.ActivityListDoctorBinding;
import com.holydev.holynicmobileapp.databinding.ActivityListHospitalBinding;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import de.hdodenhof.circleimageview.CircleImageView;

public class ListHospital extends AppCompatActivity {

    private static final String TAG = ListDoctor.class.getSimpleName();
    private ActivityListHospitalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doctor);
        binding = ActivityListHospitalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.listQuotes.setLayoutManager(layoutManager);

//        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
//        binding.listQuotes.addItemDecoration(itemDecoration);

        getListQuotes();
    }

    private void getListQuotes() {
        binding.progressBar.setVisibility(View.VISIBLE);
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://api.mresearch.app/hospital";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                binding.progressBar.setVisibility(View.INVISIBLE);

                ArrayList<String> listName = new ArrayList<>();
                ArrayList<String> listCategory = new ArrayList<>();
                ArrayList<String> listPhoto = new ArrayList<>();
                String result = new String(responseBody);
                Log.d(TAG, result);
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray doctorsArray = jsonObject.getJSONArray("hospitals");
                    for (int i = 0; i < doctorsArray.length(); i++) {
                        JSONObject doctorObject = doctorsArray.getJSONObject(i);
                        String category = doctorObject.getString("hospitalAddress");
                        String name = doctorObject.getString("hospitalName");
                        String photo = doctorObject.getString("hospitalImage");
                        listName.add(name);
                        listCategory.add(category);
                        listPhoto.add(photo);
                    }
                    DoctorAdapter adapter = new DoctorAdapter(listName,listCategory, listPhoto);

                    binding.listQuotes.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(ListHospital.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                binding.progressBar.setVisibility(View.INVISIBLE);
                String errorMessage;
                switch (statusCode) {
                    case 401:
                        errorMessage = statusCode + " : Bad Request";
                        break;
                    case 403:
                        errorMessage = statusCode + " : Forbidden";
                        break;
                    case 404:
                        errorMessage = statusCode + " : Not Found";
                        break;
                    default:
                        errorMessage = statusCode + " : " + error.getMessage();
                        break;
                }
                Toast.makeText(ListHospital.this, errorMessage, Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}