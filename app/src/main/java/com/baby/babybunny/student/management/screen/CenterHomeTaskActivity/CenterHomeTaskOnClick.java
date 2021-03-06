package com.baby.babybunny.student.management.screen.CenterHomeTaskActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class CenterHomeTaskOnClick implements View.OnClickListener{
    CenterHomeTaskActivity centerHomeTaskActivity;
    CenterHomeTaskViewBind centerHomeTaskViewBind;

    public CenterHomeTaskOnClick(CenterHomeTaskActivity centerHomeTaskActivity,CenterHomeTaskViewBind centerHomeTaskViewBind) {
        this.centerHomeTaskActivity=centerHomeTaskActivity;
        this.centerHomeTaskViewBind=centerHomeTaskViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        centerHomeTaskViewBind.back_icon.setOnClickListener(this);
        centerHomeTaskViewBind.select_calender.setOnClickListener(this);
        centerHomeTaskViewBind.tvSearchid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
             centerHomeTaskActivity.onBackPressed();
            }
            break;

            case R.id.select_calender:{

                centerHomeTaskActivity.calender();
                /* StartTime .show();*/
            }
            break;

            case R.id.tvSearchid :{
              centerHomeTaskActivity.homework_filter();
            }

        }
    }
}

