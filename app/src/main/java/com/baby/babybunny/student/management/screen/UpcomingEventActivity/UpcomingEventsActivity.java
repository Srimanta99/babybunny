package com.baby.babybunny.student.management.screen.UpcomingEventActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.babybunny.student.management.R;

public class UpcomingEventsActivity extends AppCompatActivity {
    UpcomingEventsViewBind upcomingEventsViewBind;
    UpcomingEventsOnClick upcomingEventsOnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_upcoming_events,null);
        setContentView(view);
        upcomingEventsViewBind= new UpcomingEventsViewBind(this,view);
        upcomingEventsOnClick=new UpcomingEventsOnClick(this,upcomingEventsViewBind);

        upcomingEventsViewBind.toolname_id.setText("Upcoming Events");

    }
}