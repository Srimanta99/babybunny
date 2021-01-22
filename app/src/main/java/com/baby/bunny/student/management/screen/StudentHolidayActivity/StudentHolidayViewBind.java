package com.baby.bunny.student.management.screen.StudentHolidayActivity;

import android.view.View;
import android.widget.ImageView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentQueryActivity.Student_Query_Activity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class StudentHolidayViewBind extends DeviceResolution {
    Student_HolidayList_Activity student_holidayList_activity;
    View view;
    ImageView back_icon;

    public StudentHolidayViewBind( Student_HolidayList_Activity student_holidayList_activity, View view) {
        super(student_holidayList_activity);
        this.student_holidayList_activity=student_holidayList_activity;
        this.view=view;
        initviewBind();
        setCustomTypeface();
    }

    // for adding custom typeface
    private void setCustomTypeface() {
        // studentlvid.setTypeface(getbebas(mainActivity));
//        btn_hello_wrold.setTypeface(getbebas(mainActivity));
    }

    // for findview
    private void initviewBind() {
        back_icon =view. findViewById(R.id.back_icon);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}

