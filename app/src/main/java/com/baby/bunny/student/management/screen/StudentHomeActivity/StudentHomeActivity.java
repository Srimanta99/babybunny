package com.baby.bunny.student.management.screen.StudentHomeActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;

public class StudentHomeActivity extends AppCompatActivity    {
    public StuHomeActivityViewBind stuHomeActivityViewBind;
    StuHomeActivityOnClick stuHomeActivityOnClick;
    String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_stu_home_,null);
        setContentView(view);

        stuHomeActivityViewBind= new StuHomeActivityViewBind(this,view);
        stuHomeActivityOnClick=new StuHomeActivityOnClick(this,stuHomeActivityViewBind);

        otp = getIntent().getStringExtra("otp");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentid, new ParentsZoneFragment()).commit();
            stuHomeActivityViewBind.navigationView.setCheckedItem(R.id.homeid);
        }



    }


  /*  @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentid);
        if(fragment instanceof ParentsZoneFragment)  {
            super.onBackPressed();
        } else getSupportFragmentManager().beginTransaction().replace(R.id.fragmentid, new ParentsZoneFragment()).commit();

    }*/

    @Override
    public void onBackPressed() {
        finish();
    }


    public void onBackButtonPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
