package com.baby.babybunny.student.management.screen.TeacherAttendenceActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;
import com.baby.babybunny.student.management.utils.MyToast;

public class TeacherAttendenceOnClick implements View.OnClickListener{
    TeacherAttendenceActivity teacherAttendenceActivity;
    TeacherAttendenceViewBind teacherAttendenceViewBind;

    public TeacherAttendenceOnClick( TeacherAttendenceActivity teacherAttendenceActivity,TeacherAttendenceViewBind teacherAttendenceViewBind) {
        this.teacherAttendenceActivity=teacherAttendenceActivity;
        this.teacherAttendenceViewBind=teacherAttendenceViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        teacherAttendenceViewBind.tvsubmmitid.setOnClickListener(this);
        teacherAttendenceViewBind.tvSearchid.setOnClickListener(this);
        teacherAttendenceViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvSearchid :{
                if (teacherAttendenceActivity.Class_id.equalsIgnoreCase("0")){
                    MyToast.show(teacherAttendenceActivity,"Please select class",true);
                }else  if (teacherAttendenceActivity. isConnected()) {
                    teacherAttendenceActivity.getAllStudent(teacherAttendenceActivity.Class_id);
                } else {
                    CustomAlertDialog.NoInternetAlert(teacherAttendenceActivity);
                }
            }
            break;

            case R.id.tvsubmmitid :{
                if (teacherAttendenceActivity. isConnected()) {
                    teacherAttendenceActivity.insertattendence(teacherAttendenceActivity. Class_id);
                } else {
                    CustomAlertDialog.NoInternetAlert(teacherAttendenceActivity);
                }

            }
            break;

            case R.id.back_icon:{
                teacherAttendenceActivity.onBackPressed();
            }
            break;

        }
    }
}
