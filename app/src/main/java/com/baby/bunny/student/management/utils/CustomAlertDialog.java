package com.baby.bunny.student.management.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;

public class CustomAlertDialog  {

    public static void NoInternetAlert(Activity activity){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity,R.style.CustomAlertDialog);
        View view= LayoutInflater.from(activity).inflate(R.layout.no_internet_alert_sample_view,null);

        builder.setView(view);
        AlertDialog dialog=builder.create();

        dialog.setCancelable(false);
        dialog.show();


        view.findViewById(R.id.okid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();


            }
        });
    }
}