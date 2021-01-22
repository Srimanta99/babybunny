package com.baby.bunny.student.management.screen.StudentHolidayActivity;

import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentQueryActivity.StudentQueryViewBind;
import com.baby.bunny.student.management.screen.StudentQueryActivity.Student_Query_Activity;

public class StudentHolidayOnClick implements View.OnClickListener{
    Student_HolidayList_Activity student_holidayList_activity;
    StudentHolidayViewBind studentHolidayViewBind;

    public StudentHolidayOnClick( Student_HolidayList_Activity student_holidayList_activity,StudentHolidayViewBind studentHolidayViewBind) {
        this.student_holidayList_activity=student_holidayList_activity;
        this.studentHolidayViewBind=studentHolidayViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        studentHolidayViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                student_holidayList_activity.onBackPressed();

            }
            break;
        }
    }
}

