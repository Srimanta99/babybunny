package com.baby.babybunny.student.management.screen.UpcomingEventActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class UpcomingEventsOnClick implements View.OnClickListener{
    UpcomingEventsActivity upcomingEventsActivity;
    UpcomingEventsViewBind upcomingEventsViewBind;

    public UpcomingEventsOnClick(UpcomingEventsActivity upcomingEventsActivity, UpcomingEventsViewBind upcomingEventsViewBind) {
        this.upcomingEventsActivity=upcomingEventsActivity;
        this.upcomingEventsViewBind=upcomingEventsViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
//        upcomingEventsViewBind.studentlvid.setOnClickListener(this);

        upcomingEventsViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.studentlvid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

            }
            break;

            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                upcomingEventsActivity.onBackPressed();

            }
            break;
        }
    }
}
