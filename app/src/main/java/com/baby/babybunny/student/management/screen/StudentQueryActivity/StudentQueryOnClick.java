package com.baby.babybunny.student.management.screen.StudentQueryActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class StudentQueryOnClick implements View.OnClickListener{
  Student_Query_Activity studentQueryActivity;
  StudentQueryViewBind studentQueryViewBind;

    public StudentQueryOnClick(Student_Query_Activity studentQueryActivity,StudentQueryViewBind studentQueryViewBind) {
        this.studentQueryActivity=studentQueryActivity;
        this.studentQueryViewBind=studentQueryViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        studentQueryViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
             studentQueryActivity.onBackPressed();

            }
            break;
        }
    }
}

