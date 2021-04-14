package com.baby.babybunny.student.management.screen.StudentHolidayActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.babybunny.student.management.R;

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

        studentHolidayViewBind. toolname_id.setText("Holiday List     ");

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