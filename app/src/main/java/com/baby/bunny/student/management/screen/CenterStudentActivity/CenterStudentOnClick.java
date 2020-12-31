package com.baby.bunny.student.management.screen.CenterStudentActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

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

