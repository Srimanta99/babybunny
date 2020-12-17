package com.baby.bunny.student.management.screen.StudentTodaysClassActivity;

import android.view.View;

import com.baby.bunny.student.management.R;

public class StudentTodayClassOnClick implements View.OnClickListener{

        StudentTodaysClass studentTodaysClass;
        StudentTodayClassViewBind studentTodayClassViewBind;

public StudentTodayClassOnClick(StudentTodaysClass studentTodaysClass, StudentTodayClassViewBind studentTodayClassViewBind) {
        this.studentTodaysClass=studentTodaysClass;
        this.studentTodayClassViewBind=studentTodayClassViewBind;
        setonclicklistner();
        }
// set click listner.
private void setonclicklistner() {
    studentTodayClassViewBind.recyclerView.setOnClickListener(this);
    studentTodayClassViewBind.back_icon.setOnClickListener(this);
        }

@Override
public void onClick(View view) {
        switch (view.getId()){
        case R.id.back_icon:{
          studentTodaysClass.onBackPressed();
        }
        break;
        }
    }


}
