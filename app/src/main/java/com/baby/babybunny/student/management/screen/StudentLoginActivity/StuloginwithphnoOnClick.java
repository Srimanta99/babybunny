package com.baby.babybunny.student.management.screen.StudentLoginActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;

public class StuloginwithphnoOnClick  implements View.OnClickListener {
    StudentLoginActivity stuloginwithphno;
    StuloginwithphnoViewBind stuloginwithphnoViewBind;

    public StuloginwithphnoOnClick(StudentLoginActivity stuloginwithphno, StuloginwithphnoViewBind stuloginwithphnoViewBind) {
        this.stuloginwithphno = stuloginwithphno;
        this.stuloginwithphnoViewBind = stuloginwithphnoViewBind;

        setonclicklistner();
    }

    // set click listner.
    private void setonclicklistner() {
        stuloginwithphnoViewBind.tvsubmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvsubmmitid: {
                if (isConnected()) {
                   stuloginwithphno.loadsubmit();

                } else {

                    Toast.makeText(stuloginwithphno, "No Internet Connection", Toast.LENGTH_SHORT).show();
                   CustomAlertDialog.NoInternetAlert(stuloginwithphno);
                }
            }

        }
    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) stuloginwithphno.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

   /* public void NoInternetAlert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(stuloginwithphno,R.style.CustomAlertDialog);
        View view= LayoutInflater.from(stuloginwithphno).inflate(R.layout.no_internet_alert_sample_view,null);

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

    }*/

}



















