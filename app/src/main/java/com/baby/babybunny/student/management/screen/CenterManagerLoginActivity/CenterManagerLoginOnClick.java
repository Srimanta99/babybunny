package com.baby.babybunny.student.management.screen.CenterManagerLoginActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;

public class CenterManagerLoginOnClick implements View.OnClickListener {
    CenterManagerLoginActivity centerManagerLoginActivity;
    CenterManagerLoginViewBind centerManagerLoginViewBind;

    public CenterManagerLoginOnClick(CenterManagerLoginActivity centerManagerLoginActivity, CenterManagerLoginViewBind centerManagerLoginViewBind) {
        this.centerManagerLoginActivity = centerManagerLoginActivity;
        this.centerManagerLoginViewBind = centerManagerLoginViewBind;

        setonclicklistner();
    }

    // set click listner.
    private void setonclicklistner() {
        centerManagerLoginViewBind.tvsubmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvsubmmitid: {
                if (isConnected()) {
                    centerManagerLoginActivity.loadsubmit();

                } else {

                    Toast.makeText(centerManagerLoginActivity, "No Internet Connection", Toast.LENGTH_SHORT).show();
                    CustomAlertDialog.NoInternetAlert(centerManagerLoginActivity);
                }



            }

        }
    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) centerManagerLoginActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }



}

