package com.baby.babybunny.student.management.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.babybunny.student.management.R;

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


    public static void NoDataFound(Activity activity){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity,R.style.CustomAlertDialog);
        View view= LayoutInflater.from(activity).inflate(R.layout.nodatafoundalert,null);

        builder.setView(view);
        AlertDialog dialog=builder.create();

      //  dialog.setCancelable(false);
        dialog.show();
     //   dialog.dismiss();

      /*  view.findViewById(R.id.okid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();


            }
        });*/
    }
}