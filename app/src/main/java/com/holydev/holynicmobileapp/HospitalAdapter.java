package com.holydev.holynicmobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {

    private ArrayList<String> listReview;
    private ArrayList<String> listPhoto;
    private ArrayList<String> listCategory;

    public HospitalAdapter(ArrayList<String> listReview,ArrayList<String> listCategory, ArrayList<String> listPhoto) {
        this.listReview = listReview;
        this.listCategory = listCategory;
        this.listPhoto = listPhoto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_quote, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tvItem.setText(listReview.get(position));
        viewHolder.category.setText(listCategory.get(position));
        String photoUrl = listPhoto.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(photoUrl)
                .into(viewHolder.imgItemPhoto);
    }

    @Override
    public int getItemCount() {
        return listReview.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem,category;
        ImageButton imgItemPhoto;

        public ViewHolder(View view) {
            super(view);
            tvItem = view.findViewById(R.id.tvItem);
            category = view.findViewById(R.id.category);
            imgItemPhoto = view.findViewById(R.id.img_item_photo);
        }
    }
}
