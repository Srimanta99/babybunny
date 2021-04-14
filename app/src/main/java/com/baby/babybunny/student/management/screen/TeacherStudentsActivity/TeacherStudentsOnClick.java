package com.baby.babybunny.student.management.screen.TeacherStudentsActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.utils.MyToast;

public class TeacherStudentsOnClick implements View.OnClickListener{
    TeacherStudentsActivity teacherStudentsActivity;
    TeacherStudentsViewBind teacherStudentsViewBind;

    public TeacherStudentsOnClick( TeacherStudentsActivity teacherStudentsActivity, TeacherStudentsViewBind teacherStudentsViewBind) {
        this.teacherStudentsActivity=teacherStudentsActivity;
        this.teacherStudentsViewBind=teacherStudentsViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        teacherStudentsViewBind.back_icon.setOnClickListener(this);
        teacherStudentsViewBind.tvSearchid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                teacherStudentsActivity.onBackPressed();

            }
            break;

            case R.id.tvSearchid :{

                if (teacherStudentsActivity.Class_id.equalsIgnoreCase("0")){
                    MyToast.show(teacherStudentsActivity,"Please select class",true);
                }else {
                    teacherStudentsActivity.getAllStudent(teacherStudentsActivity. Class_id);
                }

            }
            break;

        }
    }
}
