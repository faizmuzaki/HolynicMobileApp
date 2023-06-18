package com.holydev.holynicmobileapp;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

public class CustomDialog {
    private static Dialog dialog;

    public static void showLoading(Activity activity) {
        View dialogView = LayoutInflater.from(activity).inflate(R.layout.layout_progress, null, false);

        dialog = new Dialog(activity);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(dialogView);

        dialog.show();
    }

    public static void hideLoading() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
