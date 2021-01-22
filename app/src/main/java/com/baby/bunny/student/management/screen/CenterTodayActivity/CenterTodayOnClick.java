package com.baby.bunny.student.management.screen.CenterTodayActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterManagerLoginActivity.CenterManagerLoginActivity;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class CenterTodayOnClick implements View.OnClickListener{
    CenterTodayActivity centerTodayActivity;
    CenterTodayViewBind centerTodayViewBind;

    public CenterTodayOnClick(CenterTodayActivity centerTodayActivity, CenterTodayViewBind centerTodayViewBind) {
        this.centerTodayActivity=centerTodayActivity;
        this.centerTodayViewBind=centerTodayViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
     //   mainActivityViewBind.studentlvid.setOnClickListener(this);
        centerTodayViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
              centerTodayActivity.onBackPressed();
            }
            break;



        }
    }
}

