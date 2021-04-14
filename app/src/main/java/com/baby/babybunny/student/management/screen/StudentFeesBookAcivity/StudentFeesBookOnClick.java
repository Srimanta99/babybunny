package com.baby.babybunny.student.management.screen.StudentFeesBookAcivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class StudentFeesBookOnClick implements View.OnClickListener{
    StudentFeesBookActivity studentFeesBookActivity;
    StudentFeesBookViewBind studentFeesBookViewBind;

    public StudentFeesBookOnClick(StudentFeesBookActivity studentFeesBookActivity, StudentFeesBookViewBind studentFeesBookViewBind) {
        this.studentFeesBookActivity=studentFeesBookActivity;
        this.studentFeesBookViewBind=studentFeesBookViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {

        studentFeesBookViewBind.back_icon.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                studentFeesBookActivity.onBackPressed();
            }
            break;
        }
    }
}
