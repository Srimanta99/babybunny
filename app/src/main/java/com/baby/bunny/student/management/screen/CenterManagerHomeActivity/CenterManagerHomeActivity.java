package com.baby.bunny.student.management.screen.CenterManagerHomeActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.FragmentCenterManager.CenterManagerFragment.CerterManagerFragment;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StuHomeActivityOnClick;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StuHomeActivityViewBind;

public class CenterManagerHomeActivity extends AppCompatActivity {
     CenterManagerHomeViewBind centerManagerHomeViewBind;
    CenterManagerHomeOnClick centerManagerHomeOnClick;
    String otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_manager_home,null);
        setContentView(view);

        centerManagerHomeViewBind= new CenterManagerHomeViewBind(this,view);
        centerManagerHomeOnClick=new CenterManagerHomeOnClick(this,centerManagerHomeViewBind);

        otp = getIntent().getStringExtra("otp");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentid, new CerterManagerFragment()).commit();
            centerManagerHomeViewBind.navigationView.setCheckedItem(R.id.homeid);
        }

    }
}