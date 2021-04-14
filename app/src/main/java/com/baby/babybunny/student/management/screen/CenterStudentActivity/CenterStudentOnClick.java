package com.baby.babybunny.student.management.screen.CenterStudentActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class CenterStudentOnClick implements View.OnClickListener{
    CenterStudentActivity centerStudentActivity;
    CenterStudentViewBind centerStudentViewBind;

    public CenterStudentOnClick(CenterStudentActivity centerStudentActivity,CenterStudentViewBind centerStudentViewBind) {
        this.centerStudentActivity=centerStudentActivity;
        this.centerStudentViewBind=centerStudentViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        centerStudentViewBind.back_icon.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                centerStudentActivity.onBackPressed();

            }
            break;

        }
    }
}

