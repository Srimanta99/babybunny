package com.baby.bunny.student.management.screen.StudentHolidayActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.StudentQueryActivity.StudentQueryOnClick;
import com.baby.bunny.student.management.screen.StudentQueryActivity.StudentQueryViewBind;
import com.baby.bunny.student.management.screen.main.MainActivityOnClick;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class Student_HolidayList_Activity extends AppCompatActivity {
    StudentHolidayViewBind studentHolidayViewBind;
    StudentHolidayOnClick studentHolidayOnClick;
    //ImageView back_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_student__holiday_list_);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_student__holiday_list_,null);
        setContentView(view);
        studentHolidayViewBind= new StudentHolidayViewBind( this,view);
        studentHolidayOnClick=new StudentHolidayOnClick(this,studentHolidayViewBind);
      /*  back_icon = findViewById(R.id.back_icon);


        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}