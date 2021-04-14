package com.baby.babybunny.student.management.screen.TeacherFragment.TeacherHomeFragment;

import android.view.View;
import android.widget.LinearLayout;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class TeacherHomeFragmentViewBind extends DeviceResolution {
    TeacherHomeFragment teacherHomeFragment;
    View view;

    LinearLayout lvidattendance,lvidholidaylist,lv_education,lv_feedbacklist,lvidfeesbook,
            lvidCompanyAchievment,lvidTodaysClass,lvupcomingeventsid,lv_hometask,lv_students,lv_notifications;


    public TeacherHomeFragmentViewBind(TeacherHomeFragment teacherHomeFragment, View view) {
        super(teacherHomeFragment.getActivity());
        this.teacherHomeFragment=teacherHomeFragment;
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
        lvidattendance=view.findViewById(R.id.lvidattendance);
        lvidholidaylist=view.findViewById(R.id.lvidholidaylist);
        lv_education=view.findViewById(R.id.lv_education);
        lv_feedbacklist=view.findViewById(R.id.lv_feedbacklist);
        lvidfeesbook=view.findViewById(R.id.lvidfeesbook);
        lvidCompanyAchievment=view.findViewById(R.id.lvidCompanyAchievment);
        lvidTodaysClass=view.findViewById(R.id.lvidTodaysClass);
        lvupcomingeventsid=view.findViewById(R.id.lvupcomingeventsid);
        lv_hometask=view.findViewById(R.id.lv_hometask);
        lv_students=view.findViewById(R.id.lv_students);
        lv_notifications=view.findViewById(R.id.lv_notifications);
    }
}