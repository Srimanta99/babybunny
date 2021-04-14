package com.baby.babybunny.student.management.screen.CenterAddStudentFeesActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class CenterAddStudentFeesOnClick implements View.OnClickListener{
    CenterAddStudentFeesActivity centerAddStudentFeesActivity;
    CenterAddStudentFeesViewBind centerAddStudentFeesViewBind;

    public CenterAddStudentFeesOnClick(CenterAddStudentFeesActivity centerAddStudentFeesActivity,CenterAddStudentFeesViewBind centerAddStudentFeesViewBind) {
        this.centerAddStudentFeesActivity=centerAddStudentFeesActivity;
        this.centerAddStudentFeesViewBind=centerAddStudentFeesViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        centerAddStudentFeesViewBind.back_icon.setOnClickListener(this);
        centerAddStudentFeesViewBind.tvsubmmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
              centerAddStudentFeesActivity.onBackPressed();
            }
            break;

            case R.id.tvsubmmitid:{
                centerAddStudentFeesActivity.addstudentFees();
            }
            break;



        }
    }
}

