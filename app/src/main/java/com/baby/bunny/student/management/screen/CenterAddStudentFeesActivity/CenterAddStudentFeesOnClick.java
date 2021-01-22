package com.baby.bunny.student.management.screen.CenterAddStudentFeesActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

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

