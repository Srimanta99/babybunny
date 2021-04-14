package com.baby.babybunny.student.management.screen.StudentAttendanceActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class StudentAttendanceOnClick implements View.OnClickListener{
    StudentAttendanceActivity studentAttendanceActivity;
    StudentAttendanceViewBind studentAttendanceViewBind;

    public StudentAttendanceOnClick( StudentAttendanceActivity studentAttendanceActivity,  StudentAttendanceViewBind studentAttendanceViewBind) {
        this.studentAttendanceActivity=studentAttendanceActivity;
        this.studentAttendanceViewBind=studentAttendanceViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        //  companyAchievementViewBind.studentlvid.setOnClickListener(this);

        studentAttendanceViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                studentAttendanceActivity.onBackPressed();
            }
            break;
        }
    }
}

