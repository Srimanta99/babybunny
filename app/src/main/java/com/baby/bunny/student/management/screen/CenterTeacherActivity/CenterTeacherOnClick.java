package com.baby.bunny.student.management.screen.CenterTeacherActivity;

import android.view.Gravity;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentViewBind;

public class CenterTeacherOnClick implements View.OnClickListener{
    CenterTeacherActivity centerTeacherActivity;
    CenterTeacherViewBind centerTeacherViewBind;

    public CenterTeacherOnClick(CenterTeacherActivity centerTeacherActivity,CenterTeacherViewBind centerTeacherViewBind) {
        this.centerTeacherActivity=centerTeacherActivity;
        this.centerTeacherViewBind=centerTeacherViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        centerTeacherViewBind.back_icon.setOnClickListener(this);
        centerTeacherViewBind.tvSearchid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                centerTeacherActivity.onBackPressed();

            }
            break;

            case R.id.tvSearchid :{

                centerTeacherActivity.classwiseteeacher(centerTeacherActivity.Class_id);

            }
            break;

        }
    }
}

