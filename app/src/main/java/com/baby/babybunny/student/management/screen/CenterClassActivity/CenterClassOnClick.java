package com.baby.babybunny.student.management.screen.CenterClassActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

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

                centerClassActivity.onBackPressed();

            }
            break;
        }
    }
}

