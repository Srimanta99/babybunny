package com.baby.babybunny.student.management.screen.CenterHolidayListActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

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

