package com.baby.babybunny.student.management.screen.TeacherLoginActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;

public class TeacherLoginOnClick implements View.OnClickListener {
    TeacherLoginActivity teacherLoginActivity;
    TeacherLoginViewBind teacherLoginViewBind;

    public TeacherLoginOnClick( TeacherLoginActivity teacherLoginActivity,  TeacherLoginViewBind teacherLoginViewBind) {
        this.teacherLoginActivity = teacherLoginActivity;
        this.teacherLoginViewBind = teacherLoginViewBind;

        setonclicklistner();
    }

    // set click listner.
    private void setonclicklistner() {
        teacherLoginViewBind.tvsubmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvsubmmitid: {
                if (isConnected()) {
                    teacherLoginActivity.loadsubmit();

                } else {

                    Toast.makeText(teacherLoginActivity, "No Internet Connection", Toast.LENGTH_SHORT).show();
                    CustomAlertDialog.NoInternetAlert(teacherLoginActivity);
                }



            }

        }
    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) teacherLoginActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }



}

