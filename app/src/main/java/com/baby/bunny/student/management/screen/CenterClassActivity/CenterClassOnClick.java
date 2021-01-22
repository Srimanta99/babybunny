package com.baby.bunny.student.management.screen.CenterClassActivity;

import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentViewBind;

public class CenterClassOnClick implements View.OnClickListener{
    CenterClassActivity centerClassActivity;
    CenterClassViewBind centerClassViewBind;

    public CenterClassOnClick(CenterClassActivity centerClassActivity,CenterClassViewBind centerClassViewBind) {
        this.centerClassActivity=centerClassActivity;
        this.centerClassViewBind=centerClassViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        centerClassViewBind.back_icon.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                centerClassActivity.onBackPressed();

            }
            break;
        }
    }
}

