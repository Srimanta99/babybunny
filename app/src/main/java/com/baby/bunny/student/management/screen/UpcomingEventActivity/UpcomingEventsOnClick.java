package com.baby.bunny.student.management.screen.UpcomingEventActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.studentlvid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

            }
            break;
        }
    }
}
