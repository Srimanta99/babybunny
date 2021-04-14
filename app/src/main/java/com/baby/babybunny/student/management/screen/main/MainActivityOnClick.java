package com.baby.babybunny.student.management.screen.main;

import android.content.Intent;
import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.CenterManagerLoginActivity.CenterManagerLoginActivity;
import com.baby.babybunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.babybunny.student.management.screen.TeacherLoginActivity.TeacherLoginActivity;

public class MainActivityOnClick implements View.OnClickListener{
    MainActivity mainActivity;
    MainActivityViewBind mainActivityViewBind;

    public MainActivityOnClick(MainActivity mainActivity, MainActivityViewBind mainActivityViewBind) {
        this.mainActivity=mainActivity;
        this.mainActivityViewBind=mainActivityViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        mainActivityViewBind.studentlvid.setOnClickListener(this);
        mainActivityViewBind.lvcentermanagerid.setOnClickListener(this);
        mainActivityViewBind.lvteacherid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.studentlvid:{
               // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                Intent mainIntent = new Intent(mainActivity, StudentLoginActivity.class);
                mainActivity.startActivity(mainIntent);
               // mainActivity.finish();
            }
            break;


            case R.id.lvcentermanagerid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                Intent mainIntent = new Intent(mainActivity, CenterManagerLoginActivity.class);
                mainActivity.startActivity(mainIntent);
                //  mainActivity.finish();
            }
            break;

            case R.id.lvteacherid:{
                Intent mainIntent = new Intent(mainActivity, TeacherLoginActivity.class);
                mainActivity.startActivity(mainIntent);
            }
        }
    }
}
