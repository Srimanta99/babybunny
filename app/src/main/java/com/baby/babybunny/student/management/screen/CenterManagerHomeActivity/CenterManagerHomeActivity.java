package com.baby.babybunny.student.management.screen.CenterManagerHomeActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.FragmentCenterManager.CenterManagerFragment.CerterManagerFragment;
import com.baby.babybunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.babybunny.student.management.utils.SessionManager;

import org.jsoup.Jsoup;

public class CenterManagerHomeActivity extends AppCompatActivity {
     CenterManagerHomeViewBind centerManagerHomeViewBind;
    CenterManagerHomeOnClick centerManagerHomeOnClick;
    String otp;
    String currentVersion;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_manager_home,null);
        setContentView(view);

        centerManagerHomeViewBind= new CenterManagerHomeViewBind(this,view);
        centerManagerHomeOnClick=new CenterManagerHomeOnClick(this,centerManagerHomeViewBind);

        otp = getIntent().getStringExtra("otp");

        centerManagerHomeViewBind.name.setText(SessionManager.getCenterManabranch_namevalue());
        centerManagerHomeViewBind.email_id.setText(SessionManager.getCenterManabranch_emailvalue());


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentid, new CerterManagerFragment()).commit();
            centerManagerHomeViewBind.navigationView.setCheckedItem(R.id.homeid);
        }
        try {
            currentVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            Log.d("sunita", "onCreate: "+currentVersion);
            new GetVersionCode().execute();

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    public class GetVersionCode extends AsyncTask<Void, String, String> {
        @Override
        protected String doInBackground(Void... voids) {

            String newVersion = null;
            try {
                newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + CenterManagerHomeActivity.this.getPackageName() + "&hl=it")
                        .timeout(30000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get()
                        .select(".hAyfc .htlgb")
                        .get(7)
                        .ownText();
                return newVersion;
            } catch (Exception e) {
                return newVersion;
            }
        }

        @Override
        protected void onPostExecute(String onlineVersion) {
            super.onPostExecute(onlineVersion);
            Log.d("update", "Current version " + currentVersion + "playstore version " + onlineVersion);

            double onlineversioncode=2.0;

            if (onlineVersion != null && !onlineVersion.isEmpty()) {
                if (Float.valueOf(currentVersion) < Float.valueOf(onlineVersion)) {
                    //show dialog
                    showUpdateDialog();
                }
            }

                /*if (Float.valueOf(currentVersion) < onlineversioncode) {
                    //show dialog
                    showUpdateDialog();
                }*/

        }
    }


    public void showUpdateDialog() {
        android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this,R.style.CustomAlertDialogforchooseimage);
        View view1= LayoutInflater.from(getApplicationContext()).inflate(R.layout.choose_image_layout,null);

        builder.setView(view1);
        dialog=builder.create();

        dialog.setCancelable(true);
        dialog.show();

        TextView tv_update,tv_cencel;

        tv_cencel=dialog.findViewById(R.id.tv_cencel);
        tv_update=dialog.findViewById(R.id.tv_update);

        tv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String appPackageName = currentVersion; // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")));
                } catch (Exception e) {
                    startActivity(
                            new Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                            )
                    );
                }
            }
        });

        tv_cencel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
}