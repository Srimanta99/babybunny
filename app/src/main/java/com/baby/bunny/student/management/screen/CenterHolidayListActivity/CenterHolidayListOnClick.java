package com.baby.bunny.student.management.screen.CenterHolidayListActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentViewBind;

public class CenterHolidayListOnClick implements View.OnClickListener{
    CenterHolidayListActivity centerHolidayListActivity;
    CenterHolidayListViewBind centerHolidayListViewBind;

    public CenterHolidayListOnClick(CenterHolidayListActivity centerHolidayListActivity,CenterHolidayListViewBind centerHolidayListViewBind) {
        this.centerHolidayListActivity=centerHolidayListActivity;
        this.centerHolidayListViewBind=centerHolidayListViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        centerHolidayListViewBind.back_icon.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
               centerHolidayListActivity.onBackPressed();
            }
            break;

        }
    }
}

